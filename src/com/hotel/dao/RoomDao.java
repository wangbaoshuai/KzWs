package com.hotel.dao;

import java.util.List;

import com.hotel.entity.Hotel;
import com.hotel.entity.Room;
import com.hotel.entity.Rtype;

public interface RoomDao {
	// 添加客房信息
	public int addRoom(Room room) throws Exception;

	// 修该客房信息
	public int updateRoom(Room room) throws Exception;

	// 删除客房信息
	public int deleteRoom(Integer rid) throws Exception;

	// 遍历客房信息
	public List<Room> findRooms() throws Exception;

	// 跟局页数查询客房
	public int findPages() throws Exception;

	public List<Room> findRoomsByPage(Integer page) throws Exception;

	// 多条件分页查询
	public List<Room> findRoomByPage(Integer page, Room room) throws Exception;

	// 根据条件查询页数
	public int findRoomPages(Room room) throws Exception;

	// 通过ID查询房屋对象
	public Room findRoomById(Integer id) throws Exception;

	// 根据酒店和客房类型查询客房
	public List<Room> findRoomByHotelAndRtype(Integer hid, Integer rid)
			throws Exception;

	// 根据酒店和页数查询客房信息
	public List<Room> findRoomByHotelAndPage(Hotel hotel, Integer nowpage)
			throws Exception;

	public int findPageByHotel(Hotel hotel) throws Exception;

	// 根据酒店，客房空闲和页数查询客房
	public List<Room> findRoomDuo(Hotel hotel, String rstate, Integer nowpage)
			throws Exception;

	public int findPage(Hotel hotel, String rstate) throws Exception;

	// 多条件分页查询
	public List<Room> findByDuo(Room room, Integer nowpage) throws Exception;

	public int findpages(Room room) throws Exception;
}
