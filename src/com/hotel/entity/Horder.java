package com.hotel.entity;

import java.util.Date;

/**
 * Horder entity. @author MyEclipse Persistence Tools
 */

public class Horder implements java.io.Serializable {

	// Fields

	private Integer OId;
	private Room room;
	private Luser luser;
	private Date ODate;
	private String OStatus;
	private Date BDate;
	private Date YDate;
	private String OName;
	private String OTelphone;

	// Constructors

	/** default constructor */
	public Horder() {
	}

	/** full constructor */
 
	// Property accessors

	public Integer getOId() {
		return this.OId;
	}

	public Horder(Integer oId, Room room, Luser luser, Date oDate,
			String oStatus, Date bDate, Date yDate, String oName,
			String oTelphone) {
		super();
		OId = oId;
		this.room = room;
		this.luser = luser;
		ODate = oDate;
		OStatus = oStatus;
		BDate = bDate;
		YDate = yDate;
		OName = oName;
		OTelphone = oTelphone;
	}

	public void setOId(Integer OId) {
		this.OId = OId;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Luser getLuser() {
		return this.luser;
	}

	public void setLuser(Luser luser) {
		this.luser = luser;
	}

	public Date getODate() {
		return this.ODate;
	}

	public void setODate(Date ODate) {
		this.ODate = ODate;
	}

	public String getOStatus() {
		return this.OStatus;
	}

	public void setOStatus(String OStatus) {
		this.OStatus = OStatus;
	}

	public Date getBDate() {
		return BDate;
	}

	public void setBDate(Date bDate) {
		BDate = bDate;
	}

	public Date getYDate() {
		return YDate;
	}

	public void setYDate(Date yDate) {
		YDate = yDate;
	}

	public String getOName() {
		return OName;
	}

	public void setOName(String oName) {
		OName = oName;
	}

	public String getOTelphone() {
		return OTelphone;
	}

	public void setOTelphone(String oTelphone) {
		OTelphone = oTelphone;
	}

}