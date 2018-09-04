package com.hotel.biz;

import com.hotel.entity.Roomdetail;

public interface RoomDetailBiz {
	// 添加客房明细
	public int add(Roomdetail rmd) throws Exception;

	// 根据客房Id查询客房明细
	public Roomdetail findByRid(Integer rid) throws Exception;

	// 删除客房明细
	public int deleteRoomDeatilByRid(Integer rid) throws Exception;

}
