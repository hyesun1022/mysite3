package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	//게시판 글쓰기
	public int write(BoardVo boardVo) {
		System.out.println("BoardService.write()");
		int count = boardDao.insertBoard(boardVo);
		return count;
	}

	//게시판 전체리스트와 검색
	public List<BoardVo> getList(String keyword){
		System.out.println("BoardService.getBoardList()");
		
		List<BoardVo> boardList = boardDao.selectList(keyword);
		return boardList;
	}
}
