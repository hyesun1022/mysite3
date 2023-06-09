package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;
import com.javaex.vo.JsonResult;

@Controller
@RequestMapping(value="/gallery")
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
	
	//갤러리 이미지 뷰어에서 삭제
	@ResponseBody
	@RequestMapping(value="/remove",method = {RequestMethod.GET,RequestMethod.POST})
	public JsonResult remove(@RequestParam("no") int no) {
		System.out.println("GalleryController.remove()");

        int count = galleryService.remove(no);
        
        JsonResult jsonResult = new JsonResult();
        jsonResult.success(count);
        
		return jsonResult;
	}
	
	
	//갤러리 이미지 뷰어
	@ResponseBody
	@RequestMapping(value="/view",method = {RequestMethod.GET,RequestMethod.POST})
	public JsonResult view(@RequestParam("no") int no) {
		System.out.println("GalleryController.view()");
		GalleryVo galleryVo = galleryService.view(no);
		
		JsonResult jsonResult = new JsonResult();
		jsonResult.success(galleryVo);

		return jsonResult;
	}
	
	
	//갤러리 이미지 전체리스트
	@RequestMapping(value="/list", method = {RequestMethod.GET,RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GalleryController.list()");
		List<GalleryVo> galleryList = galleryService.getGalleryList();
		model.addAttribute("galleryList", galleryList);
		
		return "gallery/list";
	}
	
	//갤러리 이미지 등록
	@RequestMapping(value="/upload", method = {RequestMethod.GET,RequestMethod.POST})
	public String upload(@RequestParam("file") MultipartFile file, 
			             @RequestParam("no") int userno,@RequestParam("content") String content) {
		System.out.println("GalleryController.upload()");
		System.out.println(userno);
		System.out.println(content);
		galleryService.restore(file,userno,content);
		
		
		return "redirect:/gallery/list";
	}
	
	
}
