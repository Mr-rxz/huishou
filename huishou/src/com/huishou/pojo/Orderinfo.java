package com.huishou.pojo;

import java.sql.Timestamp;

/**
 * Orderinfo entity. @author MyEclipse Persistence Tools
 */

public class Orderinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userinfoid;
	private String address;
	private String telephone;
	private String username;
	private Integer communityid;
	private String period;
	private Integer state;
	private Timestamp createtime;

	// Constructors

	/** default constructor */
	public Orderinfo() {
	}

	/** full constructor */
	public Orderinfo(Integer userinfoid, String address, String telephone,
			String username, Integer communityid, String period, Integer state,
			Timestamp createtime) {
		this.userinfoid = userinfoid;
		this.address = address;
		this.telephone = telephone;
		this.username = username;
		this.communityid = communityid;
		this.period = period;
		this.state = state;
		this.createtime = createtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserinfoid() {
		return this.userinfoid;
	}

	public void setUserinfoid(Integer userinfoid) {
		this.userinfoid = userinfoid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getCommunityid() {
		return this.communityid;
	}

	public void setCommunityid(Integer communityid) {
		this.communityid = communityid;
	}

	public String getPeriod() {
		return this.period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

}