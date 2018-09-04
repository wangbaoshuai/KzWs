package com.hotel.biz.impl;

import java.util.List;

import com.hotel.biz.RoomBiz;
import com.hotel.dao.RoomDao;
import com.hotel.entity.Hotel;
import com.hotel.entity.Room;
import com.hotel.entity.Rtype;

public class RoomBizImpl implements RoomBiz {
	private RoomDao roomDao;

	@Override
	public int addRoom(Room room) throws Exception {
		// TODO Auto-generated method stub
		return roomDao.addRoom(room);
	}

	@Override
	public int updateRoom(Room room) throws Exception {
		// TODO Auto-generated method stub
		return roomDao.updateRoom(room);
	}

	@Override
	public int deleteRoom(Integer rid) throws Exception {
		// TODO Auto-generated method stub
		return roomDao.deleteRoom(rid);
	}

	@Override
	public List<Room> findRooms() throws Exception {
		// TODO Auto-generated method stub
		return roomDao.findRooms();
	}

	@Override
	public List<Room> findRoomByPage(Integer page, Room room) throws Exception {
		// TODO Auto-generated method stub
		return roomDao.findRoomByPage(page, room);
	}

	@Override
	public int findRoomPages(Room room) throws Exception {
		// TODO Auto-generated method stub
		return roomDao.findRoomPages(room);
	}

	@Override
	public Room findRoomById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return roomDao.findRoomById(id);
	}

	public RoomDao getRoomDao() {
		return roomDao;
	}

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	@Override
	public List<Room> findRoomsByPage(Integer page) throws Exception {
		// TODO Auto-generated method stub
		return roomDao.findRoomsByPage(page);
	}

	@Override
	public int findPages() throws Exception {
		// TODO Auto-generated method stub
		return roomDao.findPages();
	}

	@Override
	public List<Room> findRoomByHotelAndRtype(Integer hid, Integer rid)
			throws Exception {
		// TODO Auto-generated method stub
		return roomDao.findRoomByHotelAndRtype(hid, rid);
	}

	@Override
	public List<Room> findRoomByHotelAndPage(Hotel hotel, Integer nowpage)
			throws Exception {
		// TODO Auto-generated method stub
		return roomDao.findRoomByHotelAndPage(hotel, nowpage);
	}

	@Override
	public int findPageByHotel(Hotel hotel) throws Exception {
		// TODO Auto-generated method stub
		return roomDao.findPageByHotel(hotel);
	}

	@Override
	public List<Room> findRoomDuo(Hotel hotel, String rstate, Integer nowpage)
			throws Exception {
		// TODO Auto-generated method stub
		return roomDao.findRoomDuo(hotel, rstate, nowpage);
	}

	@Override
	public int findPage(Hotel hotel, String rstate) throws Exception {
		// TODO Auto-generated method stub
		return roomDao.findPage(hotel, rstate);
	}

	@Override
	public List<Room> findByDuo(Room room, Integer nowpage) throws Exception {
		// TODO Auto-generated method stub
		return roomDao.findByDuo(room, nowpage);
	}

	@Override
	public int findpages(Room room) throws Exception {
		// TODO Auto-generated method stub
		return roomDao.findpages(room);
	}

}
