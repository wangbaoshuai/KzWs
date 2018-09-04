package com.hotel.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Luser entity. @author MyEclipse Persistence Tools
 */

public class Luser implements java.io.Serializable {

	// Fields

	private Integer UId;
	private String ULoginname;
	private String ULoginpass;
	private String USex;
	private String UTelephone;
	private String UAddress;
	private String UType;
	private String UIdcard;
	private String UEmail;
	private String UImage;
	private Integer UIsadmin;
	private Integer UScore;
	private String UStatus;
	private Integer maxUScore;
	private Set horders = new HashSet(0);
	private Set hmessages = new HashSet(0);
	private Set hcomments = new HashSet(0);

	public Luser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Luser(Integer uId, String uLoginname, String uLoginpass,
			String uSex, String uTelephone, String uAddress, String uType,
			String uIdcard, String uEmail, String uImage, Integer uIsadmin,
			Integer uScore, String uStatus, Integer maxUScore, Set horders,
			Set hmessages, Set hcomments) {
		super();
		UId = uId;
		ULoginname = uLoginname;
		ULoginpass = uLoginpass;
		USex = uSex;
		UTelephone = uTelephone;
		UAddress = uAddress;
		UType = uType;
		UIdcard = uIdcard;
		UEmail = uEmail;
		UImage = uImage;
		UIsadmin = uIsadmin;
		UScore = uScore;
		UStatus = uStatus;
		maxUScore = maxUScore;
		this.horders = horders;
		this.hmessages = hmessages;
		this.hcomments = hcomments;
	}

	public Integer getUId() {
		return UId;
	}

	public void setUId(Integer uId) {
		UId = uId;
	}

	public String getULoginname() {
		return ULoginname;
	}

	public void setULoginname(String uLoginname) {
		ULoginname = uLoginname;
	}

	public String getULoginpass() {
		return ULoginpass;
	}

	public void setULoginpass(String uLoginpass) {
		ULoginpass = uLoginpass;
	}

	public String getUSex() {
		return USex;
	}

	public void setUSex(String uSex) {
		USex = uSex;
	}

	public String getUTelephone() {
		return UTelephone;
	}

	public void setUTelephone(String uTelephone) {
		UTelephone = uTelephone;
	}

	public String getUAddress() {
		return UAddress;
	}

	public void setUAddress(String uAddress) {
		UAddress = uAddress;
	}

	public String getUType() {
		return UType;
	}

	public void setUType(String uType) {
		UType = uType;
	}

	public String getUIdcard() {
		return UIdcard;
	}

	public void setUIdcard(String uIdcard) {
		UIdcard = uIdcard;
	}

	public String getUEmail() {
		return UEmail;
	}

	public void setUEmail(String uEmail) {
		UEmail = uEmail;
	}

	public Integer getUIsadmin() {
		return UIsadmin;
	}

	public String getUImage() {
		return UImage;
	}

	public void setUImage(String uImage) {
		UImage = uImage;
	}

	public void setUIsadmin(Integer uIsadmin) {
		UIsadmin = uIsadmin;
	}

	public Integer getUScore() {
		return UScore;
	}

	public void setUScore(Integer uScore) {
		UScore = uScore;
	}

	public Set getHorders() {
		return horders;
	}

	public void setHorders(Set horders) {
		this.horders = horders;
	}

	public Set getHmessages() {
		return hmessages;
	}

	public void setHmessages(Set hmessages) {
		this.hmessages = hmessages;
	}

	public Set getHcomments() {
		return hcomments;
	}

	public void setHcomments(Set hcomments) {
		this.hcomments = hcomments;
	}

	public String getUStatus() {
		return UStatus;
	}

	public void setUStatus(String uStatus) {
		UStatus = uStatus;
	}

	public Integer getMaxUScore() {
		return maxUScore;
	}

	public void setMaxUScore(Integer maxUScore) {
		this.maxUScore = maxUScore;
	}
}