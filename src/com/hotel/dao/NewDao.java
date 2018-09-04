package com.hotel.dao;

import java.util.List;

import com.hotel.entity.Hnew;
import com.hotel.entity.Room;

public interface NewDao {
	// 添加新闻的方法
	public int addNew(Hnew news) throws Exception;

	// 删除新闻的方法
	public int deleteNew(Integer nid) throws Exception;

	// 修改新闻的方法
	public int updateNew(Hnew news) throws Exception;

	// 查询新闻列表
	public List<Hnew> findNews() throws Exception;

	// 查询页数
	public int findNewPages() throws Exception;

	// 根据页数查询新闻的方法
	public List<Hnew> findNewsByPage(Integer page) throws Exception;

	// 查询单个新闻的方法
	public Hnew findNewsByNid(Integer nid) throws Exception;

}
