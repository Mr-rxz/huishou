package com.huishou.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.huishou.pojo.Orderinfo;
import com.huishou.pojo.Userinfo;
import com.huishou.service.OrderService;
import com.huishou.service.RecyclemanService;
import com.huishou.util.CodeUtil;
import com.huishou.util.Constant;
import com.opensymphony.xwork2.ActionContext;

public class OrderAction {

	private String address;
	private String telephone;
	private String username;
	private Integer communityid;
	private String period;
	private Integer orderid;
	
	public void order(){
//		//address = CodeUtil.getUTF8Encoding(address);
		//username = CodeUtil.getUTF8Encoding(username);
		Integer userinfoid = (Integer) ActionContext.getContext().getSession().get("userinfoid");
		
//		System.out.println("*********************");
//		System.out.println("address£º" + CodeUtil.getEncoding(address) + ":" + address);
//		System.out.println("address£º" + CodeUtil.getEncoding(address) + ":" + address);
//		System.out.println("telephone: " + telephone);
//		System.out.println("username : " + username);
//		System.out.println("communityid: " + communityid);
//		System.out.println("period : " + period);
//		System.out.println("userinfoid : " + userinfoid);
//		System.out.println("*********************");
		
		if(userinfoid != null){
			Timestamp time = new Timestamp(System.currentTimeMillis());
			Orderinfo order = new Orderinfo(userinfoid, address, telephone, username, communityid, period, Constant.DISTRIBUTION_STATE_CREATE, time);
			// Deal with service
			OrderService.createOrder(order);
		}
		
		// goto getinfo
		try {
			ServletActionContext.getResponse().sendRedirect("getorder.action");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getorder(){
		Userinfo userinfo = (Userinfo) ServletActionContext.getRequest().getSession().getAttribute("userinfo");
		
		System.out.println("mytest1+" + userinfo);
		System.out.println("mytest2+" + userinfo.getType());
		
		switch (userinfo.getType()) {
		case Constant.USERINFO_TYPE_USER:
		{
			List<Orderinfo> orderlist = OrderService.getOrderList(userinfo.getId());
			// save in session
			ServletActionContext.getRequest().getSession().setAttribute("orderlist", orderlist);
			// goto Order.JSP
			try {
				ServletActionContext.getResponse().sendRedirect(Constant.ORDER_URL);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			break;
		case Constant.USERINFO_TYPE_RECYCLEMAN:
		{
			List<Orderinfo> orderinfolist = RecyclemanService.getOrderList(userinfo.getId());
			// save in session
			ServletActionContext.getRequest().getSession().setAttribute("orderlist", orderinfolist);
			// goto Order_recycleman.JSP
			try {
				ServletActionContext.getResponse().sendRedirect(Constant.ORDER_RECYCLEMAN_URL);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
			break;
		default:
			break;
		}
	}
	
	public String receive(){
		//System.out.println("orderid:" + orderid);
		OrderService.receiveOrder(orderid);
		//System.out.println("*********¡¡receive.action");
		return "success";
	}
	
	public String done(){
		//System.out.println("orderid:" + orderid);
		OrderService.doneOrder(orderid);
		//System.out.println("*********¡¡done.action");
		return "success";
	}
	
	public String cancel(){
		//System.out.println("orderid:" + orderid);
		OrderService.cancelOrder(orderid);
		//System.out.println("*********¡¡done.action");
		return "success";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getCommunityid() {
		return communityid;
	}

	public void setCommunityid(Integer communityid) {
		this.communityid = communityid;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	
	
}
