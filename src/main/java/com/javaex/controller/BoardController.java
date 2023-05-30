package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//게시판 글쓰기
	@RequestMapping(value="/board/write",method = {RequestMethod.GET,RequestMethod.POST})
	public String write(HttpSession session, @ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController.write()");
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		int no = authUser.getNo();
        boardVo.setUser_no(no);
        boardService.write(boardVo);
		return "/board/writeForm";
	}
	
	
	
	//게시판 글쓰기폼
//	@RequestMapping(value="/board/writeForm",method = {RequestMethod.GET,RequestMethod.POST})
//	public String writeForm(HttpSession session, Model model){
//		System.out.println("BoardController.writeForm()");
//		
//		UserVo authUser = (UserVo)session.getAttribute("authUser");
//		int no = authUser.getNo();
//		
//		BoardVo boardVo = boardService.writeForm(no);
//		model.addAttribute(boardVo);
//
//		return "/board/writeForm";
//	}
	
	//게시판 전체 리스트
	@RequestMapping(value="/board/list",method = {RequestMethod.GET,RequestMethod.POST})
	public String allList(Model model) {
		System.out.println("boardController.allList()");
		List<BoardVo> boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);
		
		return "/board/list";
	}
}
