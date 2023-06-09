package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//갤러리 삭제
	public int deleteGallery(int no) {
		System.out.println("GalleryDao.deleteGallery()");
		
		int count = sqlSession.delete("gallery.delete", no);
		return count;
	}
	
	//갤러리 뷰어(하나의 이미지 선택)
	public GalleryVo selectGallery(int no) {
		System.out.println("GalleryDao.selectGallery()");
		
		GalleryVo galleryVo = sqlSession.selectOne("gallery.selectByNo", no);
		return galleryVo;
	}
	
	//갤러리 전체리스트 검색
	public List<GalleryVo> selectList() {
		System.out.println("GalleryDao.selectList()");
		List<GalleryVo> galleryList = sqlSession.selectList("gallery.selectList");
		return galleryList;
	}
	
	//갤러리 이미지 등록
	public int insert(GalleryVo galleryVo) {
		System.out.println("GalleryDao.insert()");
		
        int count = sqlSession.insert("gallery.insertGallery", galleryVo);
        return count;
	}
	

}
