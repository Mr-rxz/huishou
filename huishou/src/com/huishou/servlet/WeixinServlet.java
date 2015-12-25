package com.huishou.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huishou.bean.TextMessage;
import com.huishou.util.CheckUtil;
import com.huishou.util.CodeUtil;
import com.huishou.util.MessageUtil;
import com.huishou.ztest.MenuTest;

public class WeixinServlet extends HttpServlet {
	
	/**
	 * 接入验证
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		
		PrintWriter out = resp.getWriter();
		if(CheckUtil.checkSignstate(signature, timestamp, nonce)){
			out.print(echostr);
		}		
	}
	
	/**
	 * 消息的接收与响应
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		// receive msg
		PrintWriter out = resp.getWriter();
		try {
			Map<String ,String > map = MessageUtil.xmlToMap(req);
			String toUserName = map.get("ToUserName");
			String fromUserName = map.get("FromUserName");
			String createTime = map.get("CreateTime");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			String msgId = map.get("MsgId");
			
			//System.out.println("Type:" + msgType + " ID:" + msgId +" Time:" + createTime);
			//System.out.println("["+fromUserName+"]->["+toUserName+"]:"+CodeUtil.filterEmoji(content));
			
//			AccessToken token = WeixinUtil.getAccessToken();
//			System.out.println(token.getToken() + ":" + token.getExpiresIn());
//			UserInfo ui = WeixinUtil.getUserInfo(token.getToken(), fromUserName);
//		    String jsonUserInfo = JSONObject.fromObject(ui).toString(); 
//			System.out.println("[userinfo]" + jsonUserInfo);
		    
			String message = null;
			// Message Text
			if(MessageUtil.MESSAGE_TEXT.equals(msgType)){
				TextMessage text = new TextMessage();
				text.setFromUserName(toUserName);
				text.setToUserName(fromUserName);
				text.setMsgType("text");
				text.setCreateTime(new Date().getTime());
				
				if(content.equals("1")){
					text.setContent(MenuTest.firstMenu());
				}else if(content.equals("?") || content.equals("？")){
					text.setContent(MenuTest.menuText());	
				}else{
					text.setContent("您的消息已经发送，我们会及时的到达处理，感谢您的使用");
				}
				//提取文本消息内容，并用短信方式发送出去Content
//				NameAdressPhone nap = new NameAdressPhone();
//				GetMessage gm = new GetMessage();
//				nap = gm.getMessage(content);
				//SendPhoneMessage.sendPhoneMessage(nap.getName(),nap.getAdress(),nap.getPhone());

				message = MessageUtil.textMessageToXml(text);
				
			// Message Event 
			}else if(MessageUtil.MESSAGE_EVNET.equals(msgType)){
				String eventType = map.get("Event");
				if(MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)){
					message = MessageUtil.initText(toUserName, fromUserName, MenuTest.menuText());
				// menu click event
				}else if(MessageUtil.MESSAGE_CLICK.equals(eventType)){
					String key = map.get("EventKey");
					if(key.equals("11")){
						message = MenuTest.initNewsMessage(toUserName, fromUserName);
					}else if(key.equals("34")){
						message = MessageUtil.initText(toUserName, fromUserName, MenuTest.aboutusMenu());
					}else{
						message = MessageUtil.initText(toUserName, fromUserName, MenuTest.menuText());
					}
				// menu view event
				}else if(MessageUtil.MESSAGE_VIEW.equals(eventType)){
					String url = map.get("EventKey");
					message = MessageUtil.initText(toUserName, fromUserName, url);
				}else if(MessageUtil.MESSAGE_SCANCODE.equals(eventType)){
					String key = map.get("EventKey");
					message = MessageUtil.initText(toUserName, fromUserName, key);
				}
			}

			
			out.print(message);
			//System.out.println(message);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
		
	}
	
}
