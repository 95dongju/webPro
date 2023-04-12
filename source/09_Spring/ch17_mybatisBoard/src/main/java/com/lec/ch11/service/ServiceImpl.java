package com.lec.ch11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.ch11.dao.BoardDao;
import com.lec.ch11.dto.BoardDto;
import com.lec.ch11.util.Paging;

@Service
public class ServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	@Override
	public List<BoardDto> boardList(String pageNum) {
		Paging paging = new Paging(boardDao.boardTotCnt(), pageNum, 10, 10);
		BoardDto bDto = new BoardDto();
		bDto.setStartRow(startRow);
				return boardDao.boardList(board);
	}

	@Override
	public int boardTotCnt() {
		return 0;
	}

	@Override
	public int boardWrite(BoardDto board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardHitUp(int bid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardDto boardDetail(int bid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int boardReplyPreStep(BoardDto board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardReply(BoardDto board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardModify(BoardDto board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(int bid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
