package com.hotel.biz;

import java.util.List;

import com.hotel.entity.Horder;
import com.hotel.entity.Luser;

public interface OrderBiz {
	// 添加订单的方法
	public int add(Horder order) throws Exception;

	// 删除订单的方法
	public int delete(Integer id) throws Exception;

	// 更新订单的方法
	public int update(Horder order) throws Exception;

	// 查询单个订单的方法
	public Horder findById(Integer id) throws Exception;

	// 遍历所有的订单
	public List<Horder> findByPage(Integer page) throws Exception;

	// 查询总页数的方法
	public int findOrderPage() throws Exception;

	// 根据Uid查询单个订单的方法
	public List<Horder> findByUId(Integer uid) throws Exception;

	// 根据状态查询订单信息
	public Horder findOrder(String ostatus) throws Exception;

	// 根据用户id和页数查询订单
	public List<Horder> findByUserAndPage(Luser user, Integer nowpage)
			throws Exception;

	public int findPageByUser(Luser user) throws Exception;

	// 多条件分页查询订单
	public List<Horder> findByduo(Horder order, Integer nowpage)
			throws Exception;

	public int findPageByduo(Horder order) throws Exception;
}
