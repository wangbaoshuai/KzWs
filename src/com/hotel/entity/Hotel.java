package com.hotel.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Hotel entity. @author MyEclipse Persistence Tools
 */

public class Hotel implements java.io.Serializable {

	// Fields

	private Integer HId;
	private Hcity hcity;
	private String HName;
	private Integer HZip;
	private String HImage;
	private String HAddress;
	private String HContent;
	private String HTelephone;
	private Set hcomments = new HashSet(0);
	private Set rooms = new HashSet(0);

	// Constructors

	/** default constructor */
	public Hotel() {
	}

	/** full constructor */
	// Property accessors

	public Integer getHId() {
		return this.HId;
	}

	public Hotel(Integer hId, Hcity hcity, String hName, Integer hZip,
			String hImage, String hAddress, String hContent, String hTelephone,
			Set hcomments, Set rooms) {
		super();
		HId = hId;
		this.hcity = hcity;
		HName = hName;
		HZip = hZip;
		HImage = hImage;
		HAddress = hAddress;
		HContent = hContent;
		HTelephone = hTelephone;
		this.hcomments = hcomments;
		this.rooms = rooms;
	}

	public Hcity getHcity() {
		return hcity;
	}

	public void setHcity(Hcity hcity) {
		this.hcity = hcity;
	}

	public String getHName() {
		return HName;
	}

	public void setHName(String hName) {
		HName = hName;
	}

	public Integer getHZip() {
		return HZip;
	}

	public void setHZip(Integer hZip) {
		HZip = hZip;
	}

	public String getHImage() {
		return HImage;
	}

	public void setHImage(String hImage) {
		HImage = hImage;
	}

	public String getHAddress() {
		return HAddress;
	}

	public void setHAddress(String hAddress) {
		HAddress = hAddress;
	}

	public String getHContent() {
		return HContent;
	}

	public void setHContent(String hContent) {
		HContent = hContent;
	}

	public String getHTelephone() {
		return HTelephone;
	}

	public void setHTelephone(String hTelephone) {
		HTelephone = hTelephone;
	}

	public Set getHcomments() {
		return hcomments;
	}

	public void setHcomments(Set hcomments) {
		this.hcomments = hcomments;
	}

	public void setHId(Integer hId) {
		HId = hId;
	}

	public Set getRooms() {
		return rooms;
	}

	public void setRooms(Set rooms) {
		this.rooms = rooms;
	}

}