package com.huishou.pojo;

/**
 * Community entity. @author MyEclipse Persistence Tools
 */

public class Community implements java.io.Serializable {

	// Fields

	private Integer id;
	private String communityname;

	// Constructors

	/** default constructor */
	public Community() {
	}

	/** full constructor */
	public Community(String communityname) {
		this.communityname = communityname;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommunityname() {
		return this.communityname;
	}

	public void setCommunityname(String communityname) {
		this.communityname = communityname;
	}

}