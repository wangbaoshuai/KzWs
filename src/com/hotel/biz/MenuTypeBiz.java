package com.hotel.biz;

import java.util.List;

import com.hotel.entity.Menutype;

public interface MenuTypeBiz {
	// 添加菜系
	public int addMenuType(Menutype mt) throws Exception;

	// 删除菜系类型
	public int deleteMenuType(Integer mtid) throws Exception;

	// 修改菜系类型
	public int updateMenuType(Menutype mt) throws Exception;

	// 遍历所有菜系类型
	public List<Menutype> findAll() throws Exception;
}
