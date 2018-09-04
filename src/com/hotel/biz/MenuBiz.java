package com.hotel.biz;

import java.util.List;

import com.hotel.entity.Hmenu;

public interface MenuBiz {
	// 添加菜系
	public int addMenu(Hmenu menu) throws Exception;

	// 删除菜系
	public int deleteMenu(Integer mid) throws Exception;

	// 修改菜系
	public int updateMenu(Hmenu menu) throws Exception;

	// 遍历菜系
	public List<Hmenu> findMenus() throws Exception;

	// 跟局页数查询客房
	public List<Hmenu> findHmenuByPage(Integer page) throws Exception;

	// 多条件分页查询
	public List<Hmenu> findMenuByPage(Integer page, Hmenu menu)
			throws Exception;

	// 根据条件查询页数
	public int findMenuPages(Hmenu menu) throws Exception;

	// 查找单个菜系
	public Hmenu findMenuById(Integer mid) throws Exception;

	// 查询总页数
	public int findPages() throws Exception;
}
