package com.hotel.entity;

import java.util.Date;

/**
 * Hmessage entity. @author MyEclipse Persistence Tools
 */

public class Hmessage implements java.io.Serializable {

	// Fields

	private Integer MId;
	private Luser luser;
	private String MTitle;
	private String MContent;
	private Date MDate;
	private String MReply;

	// Constructors

	/** default constructor */
	public Hmessage() {
	}

	/** full constructor */
	public Hmessage(Luser luser, String MTitle, String MContent, Date MDate,
			String MReply) {
		this.luser = luser;
		this.MTitle = MTitle;
		this.MContent = MContent;
		this.MDate = MDate;
		this.MReply = MReply;
	}

	// Property accessors

	public Integer getMId() {
		return this.MId;
	}

	public void setMId(Integer MId) {
		this.MId = MId;
	}

	public Luser getLuser() {
		return this.luser;
	}

	public void setLuser(Luser luser) {
		this.luser = luser;
	}

	public String getMTitle() {
		return this.MTitle;
	}

	public void setMTitle(String MTitle) {
		this.MTitle = MTitle;
	}

	public String getMContent() {
		return this.MContent;
	}

	public void setMContent(String MContent) {
		this.MContent = MContent;
	}

	public Date getMDate() {
		return this.MDate;
	}

	public void setMDate(Date MDate) {
		this.MDate = MDate;
	}

	public String getMReply() {
		return this.MReply;
	}

	public void setMReply(String MReply) {
		this.MReply = MReply;
	}

}