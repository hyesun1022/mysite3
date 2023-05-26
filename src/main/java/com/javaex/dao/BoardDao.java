package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//게시판 전체리스트
	public List<BoardVo> selectList(){
		System.out.println("BoardDao.selectList()");
//		List<BoardVo> boardList = sqlSession.selectList("selectList");
//		System.out.println(boardList);
		return null;
	}

}
