package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//게시판 전체 리스트
	@RequestMapping(value="/board/list",method = {RequestMethod.GET,RequestMethod.POST})
	public String allList(Model model) {
		System.out.println("boardController.allList()");
		List<BoardVo> boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);
		
		return "/board/list";
	}
}
