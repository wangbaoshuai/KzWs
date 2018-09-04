package com.hotel.biz;

import java.util.List;

import com.hotel.entity.Hcity;
import com.hotel.entity.Hotel;

public interface HotelBiz {
	// 添加酒店
	public int addHotel(Hotel hotel) throws Exception;

	// 删除酒店
	public int deleteHotel(Integer hid) throws Exception;

	// 修改酒店
	public int updateHotel(Hotel hotel) throws Exception;

	// 遍历所有的酒店
	public List<Hotel> findHotels() throws Exception;

	// 根据Id查找酒店
	public Hotel findByhid(Integer hid) throws Exception;

	// 根据城市查询酒店
	public Hotel findByCity(Hcity hcity) throws Exception;

	// 根据页数遍历所有的酒店
	public List<Hotel> findHotelsByPage(Integer nowpage) throws Exception;

	public int findPages() throws Exception;

	// 根据酒店查询酒店以及酒店下的所有的评论
	public Hotel findByHotel(Hotel hotel) throws Exception;
}
