package com.huishou.service;

import java.util.List;

import org.hibernate.Transaction;

import com.huishou.bean.UserInfo_Web;
import com.huishou.dao.UserinfoDAO;
import com.huishou.pojo.Userinfo;
import com.huishou.util.Constant;
import com.huishou.util.HibernateSessionFactory;

public class UserService {

	private static UserinfoDAO userinfoDAO = new UserinfoDAO(); 
	
	public static Userinfo login(UserInfo_Web ui_web){
		final Transaction tx = userinfoDAO.getSession().beginTransaction();
		
		@SuppressWarnings("unchecked")
		List<Userinfo> uilist = userinfoDAO.findByOpenid(ui_web.getOpenid());
		Userinfo ui = null;
		
		// first create
		if(uilist.size() == 0){
			String privilege = "";
			for(String item : ui_web.getPrivilege()){
				privilege += item;
			}
			if(ui_web.getUnionid() == null) ui_web.setUnionid("");
			ui = new Userinfo(ui_web.getOpenid(), ui_web.getNickname(), ui_web.getSex(), ui_web.getProvince(), ui_web.getCity(), ui_web.getCountry(),
					ui_web.getHeadimgurl(), privilege, ui_web.getUnionid(), Constant.USERINFO_TYPE_USER);
			userinfoDAO.save(ui);
		// not first create
		}else{
			String privilege = "";
			for(String item : ui_web.getPrivilege()){
				privilege += item;
			}
			if(ui_web.getUnionid() == null) ui_web.setUnionid("");
			ui = new Userinfo(ui_web.getOpenid(), ui_web.getNickname(), ui_web.getSex(), ui_web.getProvince(), ui_web.getCity(), ui_web.getCountry(),
					ui_web.getHeadimgurl(), privilege, ui_web.getUnionid(), Constant.USERINFO_TYPE_USER);
			ui.setId(uilist.get(0).getId());
			ui.setType(uilist.get(0).getType());
			userinfoDAO.merge(ui);
		}
		
		tx.commit();
		HibernateSessionFactory.getSession().close();
		
		return ui;
	}
}
