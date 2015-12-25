package com.huishou.pojo;

/**
 * Distribution entity. @author MyEclipse Persistence Tools
 */

public class Distribution implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userid;
	private String address;
	private String telephone;
	private String username;
	private Integer communityid;

	// Constructors

	/** default constructor */
	public Distribution() {
	}

	/** full constructor */
	public Distribution(Integer userid, String address, String telephone,
			String username, Integer communityid) {
		this.userid = userid;
		this.address = address;
		this.telephone = telephone;
		this.username = username;
		this.communityid = communityid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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

}