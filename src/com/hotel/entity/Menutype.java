package com.hotel.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Menutype entity. @author MyEclipse Persistence Tools
 */

public class Menutype implements java.io.Serializable {

	// Fields

	private Integer mtId;
	private String mtName;
	private Set hmenus = new HashSet(0);

	// Constructors

	/** default constructor */
	public Menutype() {
	}

	/** full constructor */
	public Menutype(String mtName, Set hmenus) {
		this.mtName = mtName;
		this.hmenus = hmenus;
	}

	// Property accessors

	public Integer getMtId() {
		return this.mtId;
	}

	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}

	public String getMtName() {
		return this.mtName;
	}

	public void setMtName(String mtName) {
		this.mtName = mtName;
	}

	public Set getHmenus() {
		return this.hmenus;
	}

	public void setHmenus(Set hmenus) {
		this.hmenus = hmenus;
	}

}