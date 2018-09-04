package com.hotel.biz;

import java.util.List;

import com.hotel.entity.Luser;

public interface UserBiz {
	// 添加用户
	public int addUser(Luser user) throws Exception;

	// 查询用户
	public List<Luser> findUser() throws Exception;

	// 修改用户信息
	public int updateUser(Luser user) throws Exception;

	// 删除用户信息
	public int deleteUserById(Integer uid) throws Exception;

	// 根据Id查询单个用户
	public Luser findLuserById(Integer uid) throws Exception;

	// 验证登录用户
	public Luser findUserByUnameandUpass(String uname, String upass)
			throws Exception;

	// 查询总页数
	public int findUserPages() throws Exception;

	// 根据页数查询
	public List<Luser> findByPage(Integer nowpage) throws Exception;

	// 多条件分页查询
	public int findPagesByUser(Luser user) throws Exception;

	public List<Luser> findUserByPage(Integer page, Luser user)
			throws Exception;

	public Luser findUserByLoginname(String loginname) throws Exception;
}
