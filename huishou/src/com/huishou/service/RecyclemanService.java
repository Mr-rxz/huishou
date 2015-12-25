package com.huishou.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import com.huishou.dao.CommunityDAO;
import com.huishou.dao.OrderinfoDAO;
import com.huishou.dao.RecyclemanDAO;
import com.huishou.pojo.Orderinfo;
import com.huishou.pojo.Recycleman;
import com.huishou.util.HibernateSessionFactory;

public class RecyclemanService {
	
	private static RecyclemanDAO recyclemanDAO = new RecyclemanDAO();
	private static OrderinfoDAO orderinfoDAO = new OrderinfoDAO();
	private static CommunityDAO communityDAO = new CommunityDAO();
	
	@SuppressWarnings("unchecked")
	public static List<Orderinfo> getOrderList(int userinfoid){
		Transaction tx = HibernateSessionFactory.getSession().beginTransaction();
		
		List<Recycleman> recyclemanlist = recyclemanDAO.findByUserinfoid(userinfoid);
		List<Integer> communityidlist = new ArrayList<Integer>();
		List<Orderinfo> orderinfolist = new ArrayList<Orderinfo>();
		
		for(Recycleman item : recyclemanlist){
			communityidlist.add(item.getCommunityid());
		}
		
		for(Integer id : communityidlist){
			List<Orderinfo> templist = orderinfoDAO.findByCommunityid(id);
			orderinfolist.addAll(templist);
		}
		
//		for(Orderinfo item : orderinfolist){
//			String address = "[" + communityDAO.findById(item.getCommunityid()).getCommunityname() + "]"
//					+ item.getAddress();
//			item.setAddress(address);
//		}
		
		tx.commit();
		HibernateSessionFactory.getSession().close();
		
		return orderinfolist;
	}
}
