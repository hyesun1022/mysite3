package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	//게시판 리스트 페이징 포함
	public Map<String, Object> getList3(int crtPage, String keyword){
		System.out.println("BoardService.getList3()");
		
		//현재페이지 음수면 1페이로 처리
		crtPage = (crtPage>=1) ?  crtPage : (crtPage = 1) ;
		
		/////////////////////////////////////////////////////////////////////////
		//리스트 가져오기
		/////////////////////////////////////////////////////////////////////////	
		//페이지당 글갯수
		int listCnt = 10;
		
		//시작글 번호 (ex) 2페이지에 1 빼고 리스트갯수 10 곱하믄 10에 1을 더하믄 rownum이 11이 됨
		int startRnum = (crtPage-1) * listCnt + 1;
		
		//끝글 번호
		int endRnum = (startRnum + listCnt) - 1;
		List<BoardVo> boardList = boardDao.selectList3(startRnum,endRnum,keyword);
		
		/////////////////////////////////////////////////////////////////////////
		//페이징 계산
		/////////////////////////////////////////////////////////////////////////
		
		//페이지당 버튼 갯수
		int pageBtnCount = 5;
		
		//전체 글갯수
		int totalCount = boardDao.totalCount(keyword);
		
		//마지막 버튼 번호
		//1 -> 1~5
		//2 -> 1~5
		//3 -> 1~5
		//4 -> 1~5
		//5 -> 1~5
		//6 -> 6~10
		//10 ->6~10
		
		int endPageBtnNo = (int)Math.ceil(crtPage/(double)pageBtnCount) * pageBtnCount ;
		
		//시작버튼 번호
		int startPageBtnNo = (endPageBtnNo - pageBtnCount) + 1;
		
		//다음 화살표 true false
		boolean next = false;
		if(endPageBtnNo * listCnt < totalCount) { //10 * 10 < 123
			next = true;
		}else {
			next = false;
			//끝 버튼 번호 endPageBtnNo 다시 계산
			endPageBtnNo = (int)Math.ceil(totalCount/(double)listCnt);
		}
		
		//이전 화살표
		boolean prev = false;
		if(startPageBtnNo!=1) {
			prev = true;
		}
		
		//맵으로 만들기
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("prev", prev);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		pMap.put("next", next);
		pMap.put("boardList", boardList);
		pMap.put("keyword", keyword);
		
		return pMap;
	}
	
	
	
	//게시판 수정
	public void modify(BoardVo boardVo) {
		System.out.println("BoardService.modify()");
		
		boardDao.updateBoard(boardVo);
	}
	
	//게시판 수정폼
	public BoardVo modifyForm(int no) {
		System.out.println("BoardService.modifyForm()");
		
		BoardVo boardVo = boardDao.selectBoard(no);
		return boardVo;
	}
	
	
	//게시판 글삭제
	public int delete(BoardVo boardVo){
		System.out.println("BoardService.delete()");
		
		int count = boardDao.deleteBoard(boardVo);
		return count;
	}
	
	
	//게시판 글쓰기
	public int write(BoardVo boardVo){
		System.out.println("BoardService.write()");
		
		int count = boardDao.insertBoard(boardVo);
		return count;
	}

	
	//게시판 전체리스트와 검색
	public List<BoardVo> getList(String keyword){
		System.out.println("BoardService.getBoardList()");
		
		List<BoardVo> boardList = boardDao.selectList(keyword);
		return boardList;
	}
}
