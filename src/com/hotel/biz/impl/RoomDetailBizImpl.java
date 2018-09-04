package com.hotel.biz.impl;

import com.hotel.biz.RoomDetailBiz;
import com.hotel.dao.RoomDetailDao;
import com.hotel.entity.Roomdetail;

public class RoomDetailBizImpl implements RoomDetailBiz {
	private RoomDetailDao rmdDao;

	public RoomDetailDao getRmdDao() {
		return rmdDao;
	}

	public void setRmdDao(RoomDetailDao rmdDao) {
		this.rmdDao = rmdDao;
	}

	@Override
	public int add(Roomdetail rmd) throws Exception {
		// TODO Auto-generated method stub
		return rmdDao.add(rmd);
	}

	@Override
	public Roomdetail findByRid(Integer rid) throws Exception {
		// TODO Auto-generated method stub
		return rmdDao.findByRid(rid);
	}

	@Override
	public int deleteRoomDeatilByRid(Integer rid) throws Exception {
		// TODO Auto-generated method stub
		return rmdDao.deleteRoomDeatilByRid(rid);
	}

}
