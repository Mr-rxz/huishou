package com.huishou.util;

import com.huishou.pojo.advance.NameAdressPhone;

/**
 * @author Administrator
 * 获取姓名、电话、地址，并封装到NameAdressPhone类中
 */
public class GetMessage {
	
	public NameAdressPhone getMessage(String msg){
		
		NameAdressPhone nap = new NameAdressPhone();
		nap.setName(getName(msg));
		nap.setPhone(getPhone(msg));
		String adr = msg.replaceAll(nap.getName(), "");
		nap.setAdress(adr.replaceAll(nap.getPhone(), ""));
		
		return nap;
	}
	
	public String getName(String str){
		String msg = "";
		for(int i=0;i<str.length();i++){
			if(32!=str.charAt(i)){
				msg = msg + str.charAt(i);
			}
			else{
				break;
			}
		}
		return msg;
	}
	
	
	//7/11
	public static String getPhone(String str){
		String msg = "";
		int count = 0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)<=57 && str.charAt(i)>=48){
				count++;
				msg = msg + str.charAt(i);
			}
			else{
				if(count<7){
					msg = "";
					count = 0;	
				}
			}
		}
		if(count>=7){
			return msg;
		}
		else
			return null;
	}
}
