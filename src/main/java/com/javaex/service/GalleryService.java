package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {
	
	@Autowired
	private GalleryDao galleryDao;
	
	String saveDir = "C:\\javaStudy\\upload";
	
	//갤러리 삭제
	public int remove(int no) {
		System.out.println("GalleryService.remove()");

        int count = galleryDao.deleteGallery(no);
        return count;
	}
	
	//갤러리 뷰어
	public GalleryVo view(int no) {
		System.out.println("GalleryService.view()");
		GalleryVo galleryVo = galleryDao.selectGallery(no);
		return galleryVo;
	}
	
	//갤러리 이미지 전체리스트
	public List<GalleryVo> getGalleryList() {
		System.out.println("GalleryService.getGalleryList()");
		List<GalleryVo> galleryList = galleryDao.selectList();
		
		return galleryList;
	}
	
	//갤러리 이미지 등록
	public void restore(MultipartFile file, int userno, String content) {
		
		System.out.println("FileUploadService.restore()");
		
		String orgName = file.getOriginalFilename();
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString()+exName;
        String filePath = saveDir + "\\" + saveName;
		long fileSize = file.getSize();
		
		try {
			byte[] fileData = file.getBytes();
			OutputStream out= new FileOutputStream(filePath);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			bout.write(fileData);
			bout.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GalleryVo galleryVo = new GalleryVo(content,filePath,orgName,saveName,fileSize,userno);
		galleryDao.insert(galleryVo);
		
		
	}

}
