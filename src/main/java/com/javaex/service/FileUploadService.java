package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	
	String saveDir = "C:\\javaStudy\\upload";
	
	
	//파일 처리
	public String restore(MultipartFile file) {
		System.out.println("FileUploadService.restore()");
		System.out.println(file.getOriginalFilename());
		
		//원파일 이름
		String orgName = file.getOriginalFilename();
		System.out.println("orgName: " + orgName);
		
		//확장자 (오리지널파일네임 뒤에서 '.'전까지의 글자를 빼내는 알고리즘) 
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println("exName: " + exName);
		
		//저장파일이름(관리하는 이름:유니크한 이름)
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString()+exName;
		System.out.println("saveName: " + saveName);
		
		//파일패스
        String filePath = saveDir + "\\" + saveName;
        System.out.println("filePath: " + filePath );
		
		//파일사이즈
		long fileSize = file.getSize();
		System.out.println("fileSize: " + fileSize);
		
		//파일 업로드(하드디스크에 저장)
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
		
		//db저장
		//-->
		
		return saveName;
		
	}
	


}
