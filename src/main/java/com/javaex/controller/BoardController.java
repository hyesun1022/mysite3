package com.javaex.controller;

import java.util.List;
import java.util.Map;

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
@RequestMapping(value="/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//게시판 리스트 페이징기능 포함
	@RequestMapping(value="/list3", method = {RequestMethod.GET,RequestMethod.POST})
	public String list3(@RequestParam(value="crtPage", required = false, defaultValue="1") int crtPage, 
			            @RequestParam(value="keyword", required = false, defaultValue="") String keyword,
			            Model model) {
		System.out.println("boardController.list()");
		
		Map<String, Object> pMap = boardService.getList3(crtPage,keyword);
		model.addAttribute("pMap", pMap);
		
		return "/board/list3";
	}
	
	
	//게시판 수정
	@RequestMapping(value="/modify", method = {RequestMethod.GET,RequestMethod.POST})
	public String modify(@ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController.modify()");
		
		boardService.modify(boardVo);
		return "redirect:/board/list";
	}
	
	
	//게시판 수정폼
	@RequestMapping(value="/modifyForm",method = {RequestMethod.GET,RequestMethod.POST})
	public String modifyForm(@RequestParam("no") int no,Model model) {
		System.out.println("BoardController.modifyForm()");
		BoardVo boardVo = boardService.modifyForm(no);
		
		model.addAttribute("boardVo", boardVo);
		return "/board/modifyForm";
	}
	
	
	//게시판 삭제
	@RequestMapping(value="/delete",method= {RequestMethod.GET,RequestMethod.POST})
	public String delete(HttpSession session,@ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController.delete()");
		boardService.delete(boardVo);
		
		return "redirect:/board/list";
	}
	
	
	//게시판 글쓰기
	@RequestMapping(value="/write",method = {RequestMethod.GET,RequestMethod.POST})
	public String write(HttpSession session,@ModelAttribute BoardVo boardVo) {
		System.out.println("BoardController.write()");
		
		//글쓰기 임시
//		for(int i=1;i<=123;i++) {
//		   String str = i + "번째 글입니다.";
//		   boardVo.setTitle(str);
           boardService.write(boardVo);
//		}
		
		return "redirect:/board/list";
	}
	
	
	//게시판 글쓰기폼
	@RequestMapping(value="/writeForm",method = {RequestMethod.GET,RequestMethod.POST})
	public String writeForm(BoardVo boardVo){

		return "/board/writeForm";
	}
	
	
	//게시판 전체 리스트와 검색 
	@RequestMapping(value="/list",method = {RequestMethod.GET,RequestMethod.POST})
	public String list(@RequestParam(value="keyword", required = false, defaultValue="") String keyword, Model model) {
		System.out.println("boardController.list()");
		List<BoardVo> boardList = boardService.getList(keyword);
		model.addAttribute("boardList", boardList);
		
		return "/board/list";
	}
	
	

	
}
