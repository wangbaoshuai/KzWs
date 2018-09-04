package com.hotel.biz.impl;

import java.util.List;

import com.hotel.biz.HotelBiz;
import com.hotel.dao.HotelDao;
import com.hotel.entity.Hcity;
import com.hotel.entity.Hotel;

public class HotelBizImpl implements HotelBiz {
	private HotelDao hotelDao;

	@Override
	public int addHotel(Hotel hotel) throws Exception {
		// TODO Auto-generated method stub
		return hotelDao.addHotel(hotel);
	}

	@Override
	public int deleteHotel(Integer hid) throws Exception {
		// TODO Auto-generated method stub
		return hotelDao.deleteHotel(hid);
	}

	@Override
	public int updateHotel(Hotel hotel) throws Exception {
		// TODO Auto-generated method stub

		return hotelDao.updateHotel(hotel);
	}

	@Override
	public List<Hotel> findHotels() throws Exception {
		// TODO Auto-generated method stub
		return hotelDao.findHotels();
	}

	@Override
	public Hotel findByhid(Integer hid) throws Exception {
		// TODO Auto-generated method stub
		return hotelDao.findByhid(hid);
	}

	public HotelDao getHotelDao() {
		return hotelDao;
	}

	public void setHotelDao(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	@Override
	public Hotel findByCity(Hcity hcity) throws Exception {
		// TODO Auto-generated method stub
		return hotelDao.findByCity(hcity);
	}

	@Override
	public List<Hotel> findHotelsByPage(Integer nowpage) throws Exception {
		// TODO Auto-generated method stub
		return hotelDao.findHotelsByPage(nowpage);
	}

	@Override
	public int findPages() throws Exception {
		// TODO Auto-generated method stub
		return hotelDao.findPages();
	}

	@Override
	public Hotel findByHotel(Hotel hotel) throws Exception {
		// TODO Auto-generated method stub
		return hotelDao.findByHotel(hotel);
	}

}
