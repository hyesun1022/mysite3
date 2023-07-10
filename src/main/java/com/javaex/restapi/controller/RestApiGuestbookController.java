package com.javaex.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;
import com.javaex.vo.JsonResult;

@RestController
@RequestMapping(value="/restapi")
public class RestApiGuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	//게스트북 전체리스트
	@RequestMapping(value="/guestbooks",method = {RequestMethod.GET})
	public JsonResult list() {
		System.out.println("RestApiGuestbookController.list()"); 
		
		List<GuestbookVo> guestList = guestbookService.getGuestList();
		System.out.println(guestList);
		
		JsonResult jsonResult = new JsonResult();
		jsonResult.success(guestList);
		
		return jsonResult;
	}
	
	   // 게스트북 등록
	   @RequestMapping(value="/guestbooks", method= {RequestMethod.POST})
	   public JsonResult writeGuest(@RequestBody GuestbookVo guestbookVo) {
	      System.out.println("RestApiGuestbookController.writeGuest()");
	      System.err.println(guestbookVo);
	      GuestbookVo guestVo = guestbookService.addGuestList(guestbookVo);
	      JsonResult jsonResult = new JsonResult();
	      jsonResult.success(guestVo); 
	      
	      return jsonResult;
	   }
	   
	   // 게스트북 삭제
	   @RequestMapping(value="/guestbooks/{no}", method = RequestMethod.DELETE)
	   public JsonResult deleteGuest(@PathVariable("no") int no, @RequestBody GuestbookVo guestbookVo) {
		   System.out.println("RestApiGuestbookController.deleteGuest()");
		   System.out.println(guestbookVo);
		   int count = guestbookService.deleteGuest(guestbookVo);
		   System.out.println("방명록삭제:"+count);
		   JsonResult jsonResult = new JsonResult();
		   jsonResult.success(count); 
		   return jsonResult;
	   }


}
