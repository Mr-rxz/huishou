package com.huishou.pojo;

/**
 * Recycleman entity. @author MyEclipse Persistence Tools
 */

public class Recycleman implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userinfoid;
	private Integer communityid;

	// Constructors

	/** default constructor */
	public Recycleman() {
	}

	/** full constructor */
	public Recycleman(Integer userinfoid, Integer communityid) {
		this.userinfoid = userinfoid;
		this.communityid = communityid;
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

	public Integer getCommunityid() {
		return this.communityid;
	}

	public void setCommunityid(Integer communityid) {
		this.communityid = communityid;
	}

}