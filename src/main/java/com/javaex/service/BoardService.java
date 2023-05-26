package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;

	//게시판 전체리스트
	public List<BoardVo> getBoardList(){
		System.out.println("BoardService.getBoardList()");
		List<BoardVo> boardList = boardDao.selectList();
		return null;
	}
}
