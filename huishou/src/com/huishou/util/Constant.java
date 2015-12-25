package com.huishou.util;

public interface Constant {
	//public static final String IP_ADDRESS = "https://rxz.tunnel.mobi";
	public static final String IP_ADDRESS = "http://huishouchao.com/";
	public static final String REDIRECT_URI = IP_ADDRESS + "/huishou/login";
	public static final String LOGIN_REDIRECT_URL = IP_ADDRESS + "/huishou/index.jsp";
	public static final String ORDER_URL = IP_ADDRESS + "/huishou/order.jsp";
	public static final String ORDER_RECYCLEMAN_URL = IP_ADDRESS + "/huishou/order_recycleman.jsp";
	
	public static final int USERINFO_TYPE_USER = 0;
	public static final int USERINFO_TYPE_RECYCLEMAN = 1;
	public static final int USERINFO_TYPE_BUSINESS = 2;
	public static final int DISTRIBUTION_STATE_CREATE = 0;
	public static final int DISTRIBUTION_STATE_RECEIVING = 1;
	public static final int DISTRIBUTION_STATE_DONE = 2;
	
} 
