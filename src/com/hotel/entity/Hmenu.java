package com.hotel.entity;

/**
 * Hmenu entity. @author MyEclipse Persistence Tools
 */

public class Hmenu implements java.io.Serializable {

	// Fields

	private Integer MId;
	private Menutype menutype;
	private String MTitle;
	private Integer MPrice;
	private String MImg;

	private Integer big_price;// 用来表示最大价格

	// Constructors

	/** default constructor */
	public Hmenu() {
	}

	/** full constructor */
	public Hmenu(Menutype menutype, String MTitle, Integer MPrice, String MImg) {
		this.menutype = menutype;
		this.MTitle = MTitle;
		this.MPrice = MPrice;
		this.MImg = MImg;
	}

	// Property accessors

	public Integer getMId() {
		return this.MId;
	}

	public void setMId(Integer MId) {
		this.MId = MId;
	}

	public Menutype getMenutype() {
		return this.menutype;
	}

	public void setMenutype(Menutype menutype) {
		this.menutype = menutype;
	}

	public String getMTitle() {
		return this.MTitle;
	}

	public void setMTitle(String MTitle) {
		this.MTitle = MTitle;
	}

	public Integer getMPrice() {
		return this.MPrice;
	}

	public void setMPrice(Integer MPrice) {
		this.MPrice = MPrice;
	}

	public String getMImg() {
		return this.MImg;
	}

	public void setMImg(String MImg) {
		this.MImg = MImg;
	}

	public Integer getBig_price() {
		return big_price;
	}

	public void setBig_price(Integer big_price) {
		this.big_price = big_price;
	}

	@Override
	public String toString() {
		return "Hmenu [MId=" + MId + ", menutype=" + menutype + ", MTitle="
				+ MTitle + ", MPrice=" + MPrice + ", MImg=" + MImg
				+ ", big_price=" + big_price + "]";
	}

}