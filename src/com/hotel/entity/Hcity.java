package com.hotel.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Hcity entity. @author MyEclipse Persistence Tools
 */

public class Hcity implements java.io.Serializable {

	// Fields

	private Integer cityId;
	private String cityName;
	private Set hotels = new HashSet(0);

	// Constructors

	/** default constructor */
	public Hcity() {
	}

	/** full constructor */
	public Hcity(String cityName, Set hotels) {
		this.cityName = cityName;
		this.hotels = hotels;
	}

	// Property accessors

	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Set getHotels() {
		return this.hotels;
	}

	public void setHotels(Set hotels) {
		this.hotels = hotels;
	}

}