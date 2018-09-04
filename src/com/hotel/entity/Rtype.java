package com.hotel.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Rtype entity. @author MyEclipse Persistence Tools
 */

public class Rtype implements java.io.Serializable {

	// Fields

	private Integer rtId;
	private String trName;
	private Set rooms = new HashSet(0);

	// Constructors

	/** default constructor */
	public Rtype() {
	}

	/** full constructor */
	public Rtype(String trName, Set rooms) {
		this.trName = trName;
		this.rooms = rooms;
	}

	// Property accessors

	public Integer getRtId() {
		return this.rtId;
	}

	public void setRtId(Integer rtId) {
		this.rtId = rtId;
	}

	public String getTrName() {
		return this.trName;
	}

	public void setTrName(String trName) {
		this.trName = trName;
	}

	public Set getRooms() {
		return this.rooms;
	}

	public void setRooms(Set rooms) {
		this.rooms = rooms;
	}

}