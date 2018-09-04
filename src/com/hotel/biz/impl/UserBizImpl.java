package com.hotel.biz.impl;

import java.util.List;

import com.hotel.biz.UserBiz;
import com.hotel.dao.UserDao;
import com.hotel.entity.Luser;

public class UserBizImpl implements UserBiz {
	private UserDao userDao;

	@Override
	public int addUser(Luser user) throws Exception {
		// TODO Auto-generated method stub
		Luser finduser = userDao.findUserByUnameandUpass(user.getULoginname(),
				user.getULoginpass());

		if (finduser == null) {
			userDao.addUser(user);
			return 1;// 添加成功
		}
		return 0;// 有相同的用户名和密码
	}

	@Override
	public List<Luser> findUser() throws Exception {
		// TODO Auto-generated method stub
		return userDao.findUser();
	}

	@Override
	public int updateUser(Luser user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	@Override
	public int deleteUserById(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		return userDao.deleteUserById(uid);
	}

	@Override
	public Luser findUserByUnameandUpass(String uname, String upass)
			throws Exception {
		// TODO Auto-generated method stub
		return userDao.findUserByUnameandUpass(uname, upass);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int findUserPages() throws Exception {
		// TODO Auto-generated method stub
		return userDao.findUserPages();
	}

	@Override
	public List<Luser> findUserByPage(Integer page, Luser user)
			throws Exception {
		// TODO Auto-generated method stub
		return userDao.findUserByPage(page, user);
	}

	@Override
	public Luser findLuserById(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		return userDao.findLuserById(uid);
	}

	@Override
	public List<Luser> findByPage(Integer nowpage) throws Exception {
		// TODO Auto-generated method stub
		return userDao.findByPage(nowpage);
	}

	@Override
	public int findPagesByUser(Luser user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.findPagesByUser(user);
	}

	@Override
	public Luser findUserByLoginname(String loginname) throws Exception {
		// TODO Auto-generated method stub
		return userDao.findUserByLoginname(loginname);
	}

}
