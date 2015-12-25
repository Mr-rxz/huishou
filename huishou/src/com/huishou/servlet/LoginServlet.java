package com.huishou.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.huishou.bean.ErrorMessage;
import com.huishou.bean.UserInfo_Web;
import com.huishou.pojo.Distribution;
import com.huishou.pojo.Orderinfo;
import com.huishou.pojo.Userinfo;
import com.huishou.service.OrderService;
import com.huishou.service.RecyclemanService;
import com.huishou.service.UserService;
import com.huishou.util.CodeUtil;
import com.huishou.util.Constant;
import com.huishou.util.WebUtil;
import com.huishou.util.WeixinUtil;

/**
 * login by oauth2
 * @author Mr-rxz
 *
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			// S1:
			//System.out.println(req.getRequestURL()+"?"+req.getQueryString());
			String code = (String) req.getParameter("code");
			String urlStr = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
			urlStr = urlStr.replace("APPID", WeixinUtil.getAppid()).replace("SECRET", WeixinUtil.getAppsecret()).replace("CODE", code);
			String resultJson = WebUtil.getURLContent(urlStr);
			JSONObject job = new JSONObject(resultJson);
			boolean successflag = job.has("openid");

			//System.out.println("S1-SUCCESS:"+successflag);
			// S2:
			if(successflag){
				String refresh_token = job.getString("refresh_token");
				
				urlStr = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
				urlStr = urlStr.replace("APPID", WeixinUtil.getAppid()).replace("REFRESH_TOKEN", refresh_token);
				resultJson = WebUtil.getURLContent(urlStr);
				job = new JSONObject(resultJson);
				successflag = job.has("openid");

				//System.out.println("S2-SUCCESS"+successflag);
				// S3:
				if(successflag){
					urlStr = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
					String openid = job.getString("openid");
					String access_token = job.getString("access_token");
					urlStr = urlStr.replace("ACCESS_TOKEN", access_token).replace("OPENID", openid);
					resultJson = WebUtil.getURLContent(urlStr);
					job = new JSONObject(resultJson);
					successflag = job.has("openid");

					//System.out.println("S3-SUCCESS"+successflag);
					// S4:
					if(successflag){
						UserInfo_Web ui = new Gson().fromJson(resultJson, UserInfo_Web.class);
						// 过滤昵称中的emoji表情
						ui.setNickname(CodeUtil.filterEmoji(ui.getNickname()));
						successlogin(req, resp, ui);
						
						//System.out.println("LOGIN-SUCCESS");
						return;
					}//S4
				}//S3
			}//S2
			
			ErrorMessage errorMsg = new Gson().fromJson(resultJson, ErrorMessage.class);
			System.out.println("LoginServlet: Error:" + errorMsg.getErrcode() + ":" + errorMsg.getErrmsg());
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void successlogin(HttpServletRequest req, HttpServletResponse resp, UserInfo_Web ui) throws IOException{
		// save in session
		req.getSession().setAttribute("user", ui);
		// save or merge info in DB
		Userinfo userinfo = UserService.login(ui);
		// save in session
		req.getSession().setAttribute("userinfoid", userinfo.getId());
		req.getSession().setAttribute("userinfo", userinfo);
		
		System.out.println("mytest11+" + userinfo);
		System.out.println("mytest22+" + userinfo.getType());
		System.out.println("mytest11+" + req.getSession().getAttribute("userinfo"));
		System.out.println("mytest22+" + ((Userinfo)req.getSession().getAttribute("userinfo")).getType());
		
		switch (userinfo.getType()) {
		case Constant.USERINFO_TYPE_USER:
			// get order baseInfo
			Distribution distribution = OrderService.getDistribution(userinfo.getId());
			req.getSession().setAttribute("distribution", distribution);
			
			// goto Index.JSP
			resp.sendRedirect(Constant.LOGIN_REDIRECT_URL);
			break;
		case Constant.USERINFO_TYPE_RECYCLEMAN:
			resp.sendRedirect("getorder.action");
			break;

		default:
			break;
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	
}
