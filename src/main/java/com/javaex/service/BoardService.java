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
	public void write(BoardVo boardVo) {
		System.out.println("BoardService.write()");
		boardDao.insertBoard(boardVo);
		System.out.println(boardVo);
	}
	
	//게시판 글쓰기폼
//	public BoardVo writeForm(int no) {
//		System.out.println("BoardService.writeForm()");
//		
//		BoardVo boardVo = boardDao.selectUser(no);
//		return boardVo;
//		
//	}

	//게시판 전체리스트
	public List<BoardVo> getBoardList(){
		System.out.println("BoardService.getBoardList()");
		
		List<BoardVo> boardList = boardDao.selectList();
		return boardList;
	}
}
