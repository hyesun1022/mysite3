package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void deleteGuest(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.deleteGuest()");
		int count = sqlSession.delete("user.deleteGuest",guestbookVo);
		System.out.println(count);
		
	}
	
	//방명록 리스트
	public List<GuestbookVo> selectGuestList() {
		System.out.println("GuestbookDao.selectGuestList()");
		List<GuestbookVo> guestbookList = sqlSession.selectList("user.selectList");
		return guestbookList;
	}
	
	//방명록 등록
	public int insertGuest(GuestbookVo guestbookVo) {
		System.out.println("GuestbookDao.insertGuest()");
		System.out.println(guestbookVo);
		
		int count = sqlSession.insert("user.insertGuest",guestbookVo);
        return count;
	}

}
