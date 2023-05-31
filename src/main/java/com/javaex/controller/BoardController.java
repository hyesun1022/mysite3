package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//게시판 삭제
	
	//게시판 글쓰기
	@RequestMapping(value="/board/write",method = {RequestMethod.GET,RequestMethod.POST})
	public String write(HttpSession session,@ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController.write()");
        boardService.write(boardVo);
		
		return "redirect:/board/list";
	}
	
	
	//게시판 글쓰기폼
	@RequestMapping(value="/board/writeForm",method = {RequestMethod.GET,RequestMethod.POST})
	public String writeForm(BoardVo boardVo){

		return "/board/writeForm";
	}
	
	
	//게시판 전체 리스트와 검색 
	@RequestMapping(value="/board/list",method = {RequestMethod.GET,RequestMethod.POST})
	public String list(@RequestParam(value="keyword", required = false, defaultValue="") String keyword, Model model) {
		System.out.println("boardController.list()");
		List<BoardVo> boardList = boardService.getList(keyword);
		model.addAttribute("boardList", boardList);
		
		return "/board/list";
	}
	

	
	
}
