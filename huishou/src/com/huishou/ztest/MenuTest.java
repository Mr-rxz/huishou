package com.huishou.ztest;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.huishou.bean.AccessToken;
import com.huishou.bean.ErrorMessage;
import com.huishou.bean.News;
import com.huishou.bean.NewsMessage;
import com.huishou.menu.Button;
import com.huishou.menu.ClickButton;
import com.huishou.menu.Menu;
import com.huishou.menu.ViewButton;
import com.huishou.util.Constant;
import com.huishou.util.MessageUtil;
import com.huishou.util.WeixinUtil;

/**
 * create menu method
 * @author Mr-rxz
 *
 */
public class MenuTest {
	
	private static String IMG_ROOT_URL = Constant.IP_ADDRESS + "/huishou/weixinimgs/";
	
	public static void main(String[] args) {
		try {
			
			AccessToken token = WeixinUtil.getAccessToken();
			System.out.println(token.getToken() + ":" + token.getExpiresIn());
			Menu menu = initMenu();
			ErrorMessage em = WeixinUtil.createMenu(token.getToken(), menu);
			System.out.println("result : " + em.getErrcode() + ":" + em.getErrmsg());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//public static String 
	
	/**
	 * 主菜单
	 * @return
	 */
	public static String menuText(){
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎您的关注，请按照菜单提示进行操作：\n\n");
		sb.append("1、会收介绍\n");
		sb.append("\n回复？调出此菜单。\n");
		sb.append("回复文本提出建议（包括BUG）。");
		return sb.toString();
	}
	

	public static String firstMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("会收是一款面向个人用户的废品回收服务，您只需在微信端下单，就会有会收认证的回收员上门回收。\n");
		sb.append("回复？显示主菜单。");
		return sb.toString();
	}
	
	public static String aboutusMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("[会收]是一款基于回收服务的数据平台，由荣成市会收网络信息技术有限公司开发。");
		sb.append("我们专注于为用户搭建一条便捷的回收渠道，提升资源的利用率。怀着环保的理念，为环境保护做出贡献。\n");
		sb.append("回复？显示主菜单。");
		return sb.toString();
	}
	
	/**
	 * 图文消息的组装
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initNewsMessage(String toUserName,String fromUserName){
		String message = null;
		List<News> newsList = new ArrayList<News>();
		NewsMessage newsMessage = new NewsMessage();
		
		News news = new News();
		news.setTitle("会收是神马？");
		news.setDescription("[会收]由荣成市会收网络信息技术有限公司开发，是一款面向于个人用户的回收服务，服务范围覆盖日常废品，电子垃圾到家具大件。价格透明，服务规范，最主要是再也不用守在窗前等收破烂的吆喝了。只需关注[微信服务号—会收]即可在您方便的时间享受我们提供的各项服务了。");
		news.setPicUrl("http://mmbiz.qpic.cn/mmbiz/UVpgBDtrZfjGA8eaMfb4bG0xmumGc6TW5yicThjACMCurTibEXsLyoZIEpQzUao9mTaDQHpicvnJ8n7JmssvqPF5g/640?wx_fmt=jpeg&wxfrom=5");
		news.setUrl("http://mp.weixin.qq.com/s?__biz=MzIzOTA3MjY4Mg==&mid=400055445&idx=1&sn=75ab4e64667ba09be62fe218e86e6060&scene=0#rd");

		newsList.add(news);
		
		news = new News();
		news.setTitle("怎样注册使用会收服务？");
		news.setDescription("");
		news.setPicUrl("http://mmbiz.qpic.cn/mmbiz/UVpgBDtrZfjGA8eaMfb4bG0xmumGc6TW8E1t8lU230mVcG1WRh2zak2vuW6GiaGyFEOBuB3DsylmZpF4QAHIjicA/640?wx_fmt=jpeg&wxfrom=5");
		news.setUrl("http://mp.weixin.qq.com/s?__biz=MzIzOTA3MjY4Mg==&mid=400055431&idx=2&sn=f09cfd3098a19dca679e0da5eb63e329#rd");
		
		newsList.add(news);
		
		news = new News();
		news.setTitle("我们都回收什么？");
		news.setDescription("");
		news.setPicUrl("http://mmbiz.qpic.cn/mmbiz/UVpgBDtrZfjGA8eaMfb4bG0xmumGc6TWdLB07gf2M1HuHF0jmKZSibrzJ5zRiaTwJ6XG7Wd8ocMnFY8VT8Kw3I8g/640?wx_fmt=jpeg&wxfrom=5");
		news.setUrl("http://mp.weixin.qq.com/s?__biz=MzIzOTA3MjY4Mg==&mid=400055431&idx=3&sn=e619e0201cf923e07d723eb4d116ec61#rd");
		
		newsList.add(news);

		news = new News();
		news.setTitle("会收价格表单");
		news.setDescription("");
		news.setPicUrl("http://mmbiz.qpic.cn/mmbiz/UVpgBDtrZfjGA8eaMfb4bG0xmumGc6TWTFDvbaQm4mNfz3hpCic2t9SQhfrmIqCcYkiaoXvCGePNYKGTzT5yJkfw/640?wx_fmt=jpeg&wxfrom=5");
		news.setUrl("http://mp.weixin.qq.com/s?__biz=MzIzOTA3MjY4Mg==&mid=400055431&idx=4&sn=e4c680c7f2243e8f75e1075d9bdc7685#rd");
		
		newsList.add(news);
		
		news = new News();
		news.setTitle("啥？一分钟弄懂垃圾分类");
		news.setDescription("");
		news.setPicUrl("http://mmbiz.qpic.cn/mmbiz/UVpgBDtrZfjGA8eaMfb4bG0xmumGc6TWzcQcQEgh2qQ0xUHMXN1JC67dibR2OJInJBrOz3evld3CtmoVRC83GzA/640?wx_fmt=jpeg&wxfrom=5");
		news.setUrl("http://mp.weixin.qq.com/s?__biz=MzIzOTA3MjY4Mg==&mid=400055431&idx=5&sn=b8d8783155ea12c328a76b70dc0d48a2#rd");
		
		newsList.add(news);
		
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MessageUtil.MESSAGE_NEWS);
		newsMessage.setArticles(newsList);
		newsMessage.setArticleCount(newsList.size());
		
		message = MessageUtil.newsMessageToXml(newsMessage);
		return message;
	}
	
//	public static String secondMenu(){
//		StringBuffer sb = new StringBuffer();
//		sb.append("慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术。");
//		sb.append("慕课网课程涵盖前端开发、PHP、Html5、Android、iOS、Swift等IT前沿技术语言，包括基础课程、实用案例、高级分享三大类型，适合不同阶段的学习人群。以纯干货、短视频的形式为平台特点，为在校学生、职场白领提供了一个迅速提升技能、共同分享进步的学习平台。");
//		return sb.toString();
//	}
//	
//	public static String threeMenu(){
//		StringBuffer sb = new StringBuffer();
//		sb.append("词组翻译使用指南\n\n");
//		sb.append("使用示例：\n");
//		sb.append("翻译足球\n");
//		sb.append("翻译中国足球\n");
//		sb.append("翻译football\n\n");
//		sb.append("回复？显示主菜单。");
//		return sb.toString();
//	}
	
	/**
	 * 组装菜单
	 * @return
	 */
	public static Menu initMenu(){
		Menu menu = new Menu();
		
		ViewButton button1 = new ViewButton();
		button1.setName("会收");
		button1.setType("view");
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
		url = url.replace("APPID", WeixinUtil.getAppid()).replace("REDIRECT_URI", Constant.REDIRECT_URI)
				.replace("SCOPE", "snsapi_userinfo").replace("STATE", "1");
		System.out.println(url);
		button1.setUrl(url);

		ClickButton button2 = new ClickButton();
		button2.setName("高级会收");
		button2.setType("click");
		button2.setKey("11");
		
		ClickButton button31 = new ClickButton();
		button31.setName("社区活动");
		button31.setType("scancode_push");
		button31.setKey("31");
		
		ClickButton button32 = new ClickButton();
		button32.setName("商家中心");
		button32.setType("location_select");
		button32.setKey("32");
		
		ClickButton button33 = new ClickButton();
		button33.setName("会收员");
		button33.setType("location_select");
		button33.setKey("33");
		
		ClickButton button34 = new ClickButton();
		button34.setName("关于我们");
		button34.setType("click");
		button34.setKey("34");
		
		Button button3 = new Button();
		button3.setName("菜单");
		button3.setSub_button(new Button[]{button31,button32,button33,button34});
		
		menu.setButton(new Button[]{button1,button2,button3});
		return menu;
	}
}
