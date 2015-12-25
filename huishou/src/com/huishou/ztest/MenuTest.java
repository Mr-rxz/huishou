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
	 * ���˵�
	 * @return
	 */
	public static String menuText(){
		StringBuffer sb = new StringBuffer();
		sb.append("��ӭ���Ĺ�ע���밴�ղ˵���ʾ���в�����\n\n");
		sb.append("1�����ս���\n");
		sb.append("\n�ظ��������˲˵���\n");
		sb.append("�ظ��ı�������飨����BUG����");
		return sb.toString();
	}
	

	public static String firstMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("������һ����������û��ķ�Ʒ���շ�����ֻ����΢�Ŷ��µ����ͻ��л�����֤�Ļ���Ա���Ż��ա�\n");
		sb.append("�ظ�����ʾ���˵���");
		return sb.toString();
	}
	
	public static String aboutusMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("[����]��һ����ڻ��շ��������ƽ̨�����ٳ��л���������Ϣ�������޹�˾������");
		sb.append("����רע��Ϊ�û��һ����ݵĻ���������������Դ�������ʡ����Ż��������Ϊ���������������ס�\n");
		sb.append("�ظ�����ʾ���˵���");
		return sb.toString();
	}
	
	/**
	 * ͼ����Ϣ����װ
	 * @param toUserName
	 * @param fromUserName
	 * @return
	 */
	public static String initNewsMessage(String toUserName,String fromUserName){
		String message = null;
		List<News> newsList = new ArrayList<News>();
		NewsMessage newsMessage = new NewsMessage();
		
		News news = new News();
		news.setTitle("����������");
		news.setDescription("[����]���ٳ��л���������Ϣ�������޹�˾��������һ�������ڸ����û��Ļ��շ��񣬷���Χ�����ճ���Ʒ�������������Ҿߴ�����۸�͸��������淶������Ҫ����Ҳ�������ڴ�ǰ�������õ�ߺ���ˡ�ֻ���ע[΢�ŷ���š�����]�������������ʱ�����������ṩ�ĸ�������ˡ�");
		news.setPicUrl("http://mmbiz.qpic.cn/mmbiz/UVpgBDtrZfjGA8eaMfb4bG0xmumGc6TW5yicThjACMCurTibEXsLyoZIEpQzUao9mTaDQHpicvnJ8n7JmssvqPF5g/640?wx_fmt=jpeg&wxfrom=5");
		news.setUrl("http://mp.weixin.qq.com/s?__biz=MzIzOTA3MjY4Mg==&mid=400055445&idx=1&sn=75ab4e64667ba09be62fe218e86e6060&scene=0#rd");

		newsList.add(news);
		
		news = new News();
		news.setTitle("����ע��ʹ�û��շ���");
		news.setDescription("");
		news.setPicUrl("http://mmbiz.qpic.cn/mmbiz/UVpgBDtrZfjGA8eaMfb4bG0xmumGc6TW8E1t8lU230mVcG1WRh2zak2vuW6GiaGyFEOBuB3DsylmZpF4QAHIjicA/640?wx_fmt=jpeg&wxfrom=5");
		news.setUrl("http://mp.weixin.qq.com/s?__biz=MzIzOTA3MjY4Mg==&mid=400055431&idx=2&sn=f09cfd3098a19dca679e0da5eb63e329#rd");
		
		newsList.add(news);
		
		news = new News();
		news.setTitle("���Ƕ�����ʲô��");
		news.setDescription("");
		news.setPicUrl("http://mmbiz.qpic.cn/mmbiz/UVpgBDtrZfjGA8eaMfb4bG0xmumGc6TWdLB07gf2M1HuHF0jmKZSibrzJ5zRiaTwJ6XG7Wd8ocMnFY8VT8Kw3I8g/640?wx_fmt=jpeg&wxfrom=5");
		news.setUrl("http://mp.weixin.qq.com/s?__biz=MzIzOTA3MjY4Mg==&mid=400055431&idx=3&sn=e619e0201cf923e07d723eb4d116ec61#rd");
		
		newsList.add(news);

		news = new News();
		news.setTitle("���ռ۸��");
		news.setDescription("");
		news.setPicUrl("http://mmbiz.qpic.cn/mmbiz/UVpgBDtrZfjGA8eaMfb4bG0xmumGc6TWTFDvbaQm4mNfz3hpCic2t9SQhfrmIqCcYkiaoXvCGePNYKGTzT5yJkfw/640?wx_fmt=jpeg&wxfrom=5");
		news.setUrl("http://mp.weixin.qq.com/s?__biz=MzIzOTA3MjY4Mg==&mid=400055431&idx=4&sn=e4c680c7f2243e8f75e1075d9bdc7685#rd");
		
		newsList.add(news);
		
		news = new News();
		news.setTitle("ɶ��һ����Ū����������");
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
//		sb.append("Ľ�����Ǵ�ֱ�Ļ�����IT�������ѧϰ��վ���Զ�����Ƶ�̡̳����߱�̹��ߡ�ѧϰ�ƻ����ʴ�����Ϊ������ɫ�������������ҵ���õĻ���������ţ�ˣ�Ҳ����ͨ����ѵ����߹�����Ƶ�γ�ѧϰ�������ȵĻ�����IT������");
//		sb.append("Ľ�����γ̺���ǰ�˿�����PHP��Html5��Android��iOS��Swift��ITǰ�ؼ������ԣ����������γ̡�ʵ�ð������߼������������ͣ��ʺϲ�ͬ�׶ε�ѧϰ��Ⱥ���Դ��ɻ�������Ƶ����ʽΪƽ̨�ص㣬Ϊ��Уѧ����ְ�������ṩ��һ��Ѹ���������ܡ���ͬ���������ѧϰƽ̨��");
//		return sb.toString();
//	}
//	
//	public static String threeMenu(){
//		StringBuffer sb = new StringBuffer();
//		sb.append("���鷭��ʹ��ָ��\n\n");
//		sb.append("ʹ��ʾ����\n");
//		sb.append("��������\n");
//		sb.append("�����й�����\n");
//		sb.append("����football\n\n");
//		sb.append("�ظ�����ʾ���˵���");
//		return sb.toString();
//	}
	
	/**
	 * ��װ�˵�
	 * @return
	 */
	public static Menu initMenu(){
		Menu menu = new Menu();
		
		ViewButton button1 = new ViewButton();
		button1.setName("����");
		button1.setType("view");
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
		url = url.replace("APPID", WeixinUtil.getAppid()).replace("REDIRECT_URI", Constant.REDIRECT_URI)
				.replace("SCOPE", "snsapi_userinfo").replace("STATE", "1");
		System.out.println(url);
		button1.setUrl(url);

		ClickButton button2 = new ClickButton();
		button2.setName("�߼�����");
		button2.setType("click");
		button2.setKey("11");
		
		ClickButton button31 = new ClickButton();
		button31.setName("�����");
		button31.setType("scancode_push");
		button31.setKey("31");
		
		ClickButton button32 = new ClickButton();
		button32.setName("�̼�����");
		button32.setType("location_select");
		button32.setKey("32");
		
		ClickButton button33 = new ClickButton();
		button33.setName("����Ա");
		button33.setType("location_select");
		button33.setKey("33");
		
		ClickButton button34 = new ClickButton();
		button34.setName("��������");
		button34.setType("click");
		button34.setKey("34");
		
		Button button3 = new Button();
		button3.setName("�˵�");
		button3.setSub_button(new Button[]{button31,button32,button33,button34});
		
		menu.setButton(new Button[]{button1,button2,button3});
		return menu;
	}
}
