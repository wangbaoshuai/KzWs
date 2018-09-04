package com.hotel.entity;

/**
 * Hnew entity. @author MyEclipse Persistence Tools
 */

public class Hnew implements java.io.Serializable {

	// Fields

	private Integer NId;
	private String NTitle;
	private String NImage;
	private String NContent;

	// Constructors

	/** default constructor */
	public Hnew() {
	}

	/** full constructor */
	public Hnew(String NTitle, String NImage, String NContent) {
		this.NTitle = NTitle;
		this.NImage = NImage;
		this.NContent = NContent;
	}

	// Property accessors

	public Integer getNId() {
		return this.NId;
	}

	public void setNId(Integer NId) {
		this.NId = NId;
	}

	public String getNTitle() {
		return this.NTitle;
	}

	public void setNTitle(String NTitle) {
		this.NTitle = NTitle;
	}

	public String getNImage() {
		return this.NImage;
	}

	public void setNImage(String NImage) {
		this.NImage = NImage;
	}

	public String getNContent() {
		return this.NContent;
	}

	public void setNContent(String NContent) {
		this.NContent = NContent;
	}

	@Override
	public String toString() {
		return "Hnew [NId=" + NId + ", NTitle=" + NTitle + ", NImage=" + NImage
				+ ", NContent=" + NContent + "]";
	}

}