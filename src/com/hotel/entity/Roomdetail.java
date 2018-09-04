package com.hotel.entity;

/**
 * Roomdetail entity. @author MyEclipse Persistence Tools
 */

public class Roomdetail implements java.io.Serializable {

	// Fields

	private Integer rdId;
	private Room room;
	private String rdTitle;
	private String rdContent;
	private String rdTelephone;
	private Double rdPrice;
	private Double rdDiscount;
	private Double rdPerhourprice;

	// Constructors

	/** default constructor */
	public Roomdetail() {
	}

	/** full constructor */
	public Roomdetail(Room room, String rdTitle, String rdContent,
			String rdTelephone, Double rdPrice, Double rdDiscount,
			Double rdPerhourprice) {
		this.room = room;
		this.rdTitle = rdTitle;
		this.rdContent = rdContent;
		this.rdTelephone = rdTelephone;
		this.rdPrice = rdPrice;
		this.rdDiscount = rdDiscount;
		this.rdPerhourprice = rdPerhourprice;
	}

	// Property accessors

	public Integer getRdId() {
		return this.rdId;
	}

	public void setRdId(Integer rdId) {
		this.rdId = rdId;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getRdTitle() {
		return this.rdTitle;
	}

	public void setRdTitle(String rdTitle) {
		this.rdTitle = rdTitle;
	}

	public String getRdContent() {
		return this.rdContent;
	}

	public void setRdContent(String rdContent) {
		this.rdContent = rdContent;
	}

	public String getRdTelephone() {
		return this.rdTelephone;
	}

	public void setRdTelephone(String rdTelephone) {
		this.rdTelephone = rdTelephone;
	}

	public Double getRdPrice() {
		return this.rdPrice;
	}

	public void setRdPrice(Double rdPrice) {
		this.rdPrice = rdPrice;
	}

	public Double getRdDiscount() {
		return this.rdDiscount;
	}

	public void setRdDiscount(Double rdDiscount) {
		this.rdDiscount = rdDiscount;
	}

	public Double getRdPerhourprice() {
		return this.rdPerhourprice;
	}

	public void setRdPerhourprice(Double rdPerhourprice) {
		this.rdPerhourprice = rdPerhourprice;
	}

}