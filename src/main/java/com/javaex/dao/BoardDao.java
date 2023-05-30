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
	public void insertBoard(BoardVo boardVo) {
		System.out.println("BoardDao.insertBoard()");
//		int count = sqlSession.insert("insertBoard",boardVo);
//		System.out.println(count);
	}
	
	//게시판 글쓰기폼(회원정보1명 가져오기)
//	public BoardVo selectUser(int no) {
//		System.out.println("BoardDao.selectUser()");
//		
//		BoardVo boardVo = sqlSession.selectOne("selectBoardbyUser",no);
//		return boardVo;
//	}
	
	//게시판 전체리스트
	public List<BoardVo> selectList(){
		System.out.println("BoardDao.selectList()");
		
		List<BoardVo> boardList = sqlSession.selectList("selectAllList");
		return boardList;
	}

}
