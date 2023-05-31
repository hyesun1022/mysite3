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
	
	//게시판 글쓰기
	public int insertBoard(BoardVo boardVo) {
		System.out.println("BoardDao.insertBoard()");
		System.out.println(boardVo);
		int count = sqlSession.insert("board.insertBoard",boardVo);
        return count;
	}
	
	//게시판 전체리스트와 검색
	public List<BoardVo> selectList(String keyword){
		System.out.println("BoardDao.selectList()");
		
		List<BoardVo> boardList = sqlSession.selectList("board.selectList",keyword);
		return boardList;
	}

}
