package com.huishou.service;

import java.util.List;

import org.hibernate.Transaction;

import com.huishou.dao.DistributionDAO;
import com.huishou.dao.OrderinfoDAO;
import com.huishou.pojo.Distribution;
import com.huishou.pojo.Orderinfo;
import com.huishou.util.Constant;
import com.huishou.util.HibernateSessionFactory;

public class OrderService {
	
	private static OrderinfoDAO orderinfoDAO = new OrderinfoDAO();
	private static DistributionDAO distributionDAO = new DistributionDAO();
	
	public static void createOrder(Orderinfo orderinfo){

		Transaction tx = HibernateSessionFactory.getSession().beginTransaction();
		
		// save orderinfo in DB
		orderinfoDAO.save(orderinfo);

		// save distributionInfo in DB
		List result1 = distributionDAO.findByAddress(orderinfo.getAddress());
		List result2 = distributionDAO.findByCommunityid(orderinfo.getCommunityid());
		List result3 = distributionDAO.findByTelephone(orderinfo.getTelephone());
		
		if(result1.size() == 0 || result2.size() == 0 || result3.size() == 0){
			Distribution distribution = new Distribution(orderinfo.getUserinfoid(), orderinfo.getAddress(),
					orderinfo.getTelephone(), orderinfo.getUsername(), orderinfo.getCommunityid());
			distributionDAO.save(distribution);
		}
		
		tx.commit();
		HibernateSessionFactory.getSession().close();
	}
	
	public static List<Orderinfo> getOrderList(int userinfoid){
		Transaction tx = HibernateSessionFactory.getSession().beginTransaction();
		List<Orderinfo> list = orderinfoDAO.findByUserinfoid(userinfoid);
		tx.commit();
		HibernateSessionFactory.getSession().close();
		return list;
	}
	
	public static Distribution getDistribution(int userinfoid){
		Transaction tx = HibernateSessionFactory.getSession().beginTransaction();
		List list = distributionDAO.findByUserid(userinfoid);
		tx.commit();
		HibernateSessionFactory.getSession().close();
		//System.out.println("orderservice: " + userinfoid + ":" + list.size());
		if(list.size() != 0){
			return (Distribution)list.get(list.size()-1);
		}
		
		return null;
	}
	
	public static void receiveOrder(int orderid){
		Transaction tx = HibernateSessionFactory.getSession().beginTransaction();
		Orderinfo oi = orderinfoDAO.findById(orderid);
		oi.setState(Constant.DISTRIBUTION_STATE_RECEIVING);
		orderinfoDAO.merge(oi);
		tx.commit();
		HibernateSessionFactory.getSession().close();
	}
	
	public static void doneOrder(int orderid){
		Transaction tx = HibernateSessionFactory.getSession().beginTransaction();
		Orderinfo oi = orderinfoDAO.findById(orderid);
		oi.setState(Constant.DISTRIBUTION_STATE_DONE);
		orderinfoDAO.merge(oi);
		tx.commit();
		HibernateSessionFactory.getSession().close();
	}
	
	public static void cancelOrder(int orderid){
		Transaction tx = HibernateSessionFactory.getSession().beginTransaction();
		Orderinfo oi = orderinfoDAO.findById(orderid);
		orderinfoDAO.delete(oi);
		tx.commit();
		HibernateSessionFactory.getSession().close();
	}

}
