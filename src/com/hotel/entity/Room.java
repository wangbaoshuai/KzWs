package com.hotel.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Room entity. @author MyEclipse Persistence Tools
 */

public class Room implements java.io.Serializable {

	// Fields
	private Integer RId;
	private Rtype rtype;
	private Hotel hotel;
	private String RTitle;
	private String RFloor;
	private Integer RBednumber;
	private String RImg;
	private String RState;
	private Integer rdTotal;
	private Integer rdBigTotal;
	private Set horders = new HashSet(0);
	private Set roomdetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Room() {
	}


	public Room(Integer rId, Rtype rtype, Hotel hotel, String rTitle,
			String rFloor, Integer rBednumber, String rImg, String rState,
			Integer rdTotal, Integer rdBigTotal, Set horders, Set roomdetails) {
		super();
		RId = rId;
		this.rtype = rtype;
		this.hotel = hotel;
		RTitle = rTitle;
		RFloor = rFloor;
		RBednumber = rBednumber;
		RImg = rImg;
		RState = rState;
		this.rdTotal = rdTotal;
		this.rdBigTotal = rdBigTotal;
		this.horders = horders;
		this.roomdetails = roomdetails;
	}


	public Integer getRId() {
		return RId;
	}

	public void setRId(Integer rId) {
		RId = rId;
	}

	public Rtype getRtype() {
		return rtype;
	}

	public void setRtype(Rtype rtype) {
		this.rtype = rtype;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getRTitle() {
		return RTitle;
	}

	public void setRTitle(String rTitle) {
		RTitle = rTitle;
	}

	public String getRFloor() {
		return RFloor;
	}

	public void setRFloor(String rFloor) {
		RFloor = rFloor;
	}

	public Integer getRBednumber() {
		return RBednumber;
	}

	public void setRBednumber(Integer rBednumber) {
		RBednumber = rBednumber;
	}

	public String getRImg() {
		return RImg;
	}

	public void setRImg(String rImg) {
		RImg = rImg;
	}

	public String getRState() {
		return RState;
	}

	public void setRState(String rState) {
		RState = rState;
	}

	public Integer getRdTotal() {
		return rdTotal;
	}

	public void setRdTotal(Integer rdTotal) {
		this.rdTotal = rdTotal;
	}

	public Set getHorders() {
		return horders;
	}

	public void setHorders(Set horders) {
		this.horders = horders;
	}

	public Set getRoomdetails() {
		return roomdetails;
	}

	public void setRoomdetails(Set roomdetails) {
		this.roomdetails = roomdetails;
	}


	public Integer getRdBigTotal() {
		return rdBigTotal;
	}


	public void setRdBigTotal(Integer rdBigTotal) {
		this.rdBigTotal = rdBigTotal;
	}


	@Override
	public String toString() {
		return "Room [RId=" + RId + ", rtype=" + rtype + ", hotel=" + hotel
				+ ", RTitle=" + RTitle + ", RFloor=" + RFloor + ", RBednumber="
				+ RBednumber + ", RImg=" + RImg + ", RState=" + RState
				+ ", rdTotal=" + rdTotal + ", rdBigTotal=" + rdBigTotal
				+ ", horders=" + horders + ", roomdetails=" + roomdetails + "]";
	}

	/** full constructor */

}