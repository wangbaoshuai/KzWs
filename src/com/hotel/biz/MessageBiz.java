package com.hotel.biz;

import java.util.List;

import com.hotel.entity.Hmessage;
import com.hotel.entity.Luser;

public interface MessageBiz {
	// 回复的方法
	public int update(Hmessage message) throws Exception;

	// 删除的方法
	public int deleteMessageByMid(Integer mid) throws Exception;

	// 查询的方法
	public List<Hmessage> findMessages() throws Exception;

	// 查询单条留言的方法
	public Hmessage findMessageByMid(Integer mid) throws Exception;

	// 添加留言
	public int addMessage(Hmessage message) throws Exception;

	// 查询总页数
	public int findMessagePages() throws Exception;

	// 按页数查找留言
	public List<Hmessage> findMessageByPage(Integer page) throws Exception;

	// 按页数和条件查询留言
	public List<Hmessage> findMessageByPage(Integer page, Hmessage message)
			throws Exception;

	// 按条件查询总页数
	public int findMessagePages(Hmessage message) throws Exception;

	// 根据用户和页数查询留言
	public int findPageByUser(Luser user) throws Exception;

	public List<Hmessage> findMessageByUserAndPage(Integer nowpage, Luser user)
			throws Exception;
}
