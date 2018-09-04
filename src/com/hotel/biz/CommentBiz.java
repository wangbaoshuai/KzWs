package com.hotel.biz;

import java.util.List;

import com.hotel.entity.Hcomment;
import com.hotel.entity.Hotel;
import com.hotel.entity.Luser;

public interface CommentBiz {
	// 添加评论
	public int addComment(Hcomment comment) throws Exception;

	// 删除评论
	public int deleteComment(Integer cid) throws Exception;

	// 修改评论
	public int updateComment(Hcomment comment) throws Exception;

	// 遍历所有的评论
	public List<Hcomment> findComments() throws Exception;

	// 查询总页数
	public int findCommentPages() throws Exception;

	// 根据页数查询评论
	public List<Hcomment> findCommentsByPage(Integer page) throws Exception;

	// 根据Id查询
	public Hcomment findHcommentById(Integer id) throws Exception;

	// 根据酒店和页数查询评论
	public int findPageByHotel(Hotel hotel) throws Exception;

	public List<Hcomment> findByPageAndHotel(Integer nowpage, Hotel hotel)
			throws Exception;

	// 根据用户和页数查询评论
	public int findPageByUser(Luser user) throws Exception;

	public List<Hcomment> findByPageAndUser(Integer nowpage, Luser user)
			throws Exception;
}
