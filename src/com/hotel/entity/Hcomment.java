package com.hotel.entity;

import java.util.Date;

/**
 * Hcomment entity. @author MyEclipse Persistence Tools
 */

public class Hcomment implements java.io.Serializable {

	// Fields

	private Integer CId;
	private Hotel hotel;
	private Luser luser;
	private String CContent;
	private Integer CScore;
	private Date CDate;

	// Constructors

	/** default constructor */
	public Hcomment() {
	}

	public Hcomment(Integer cId, Hotel hotel, Luser luser, String cContent,
			Integer cScore, Date cDate) {
		super();
		CId = cId;
		this.hotel = hotel;
		this.luser = luser;
		CContent = cContent;
		CScore = cScore;
		CDate = cDate;

	}

	public Integer getCId() {
		return CId;
	}

	public void setCId(Integer cId) {
		CId = cId;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Luser getLuser() {
		return luser;
	}

	public void setLuser(Luser luser) {
		this.luser = luser;
	}

	public String getCContent() {
		return CContent;
	}

	public void setCContent(String cContent) {
		CContent = cContent;
	}

	public Integer getCScore() {
		return CScore;
	}

	public void setCScore(Integer cScore) {
		CScore = cScore;
	}

	public Date getCDate() {
		return CDate;
	}

	public void setCDate(Date cDate) {
		CDate = cDate;
	}

	/** full constructor */

}