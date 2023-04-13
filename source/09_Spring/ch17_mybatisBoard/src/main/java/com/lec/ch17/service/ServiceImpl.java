package com.lec.ch17.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lec.ch17.dao.BoardDao;
import com.lec.ch17.dto.BoardDto;
import com.lec.ch17.util.Paging;

@Service
public class ServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	@Override
	public List<BoardDto> boardList(String pageNum) {
		Paging paging = new Paging(boardDao.boardTotCnt(), pageNum, 10, 10);
		BoardDto board = new BoardDto();
		board.setStartRow(paging.getStartRow());
		board.setEndRow(paging.getEndRow());
		return boardDao.boardList(board);
	}

	@Override
	public int boardTotCnt() {
		return boardDao.boardTotCnt();
	}

	@Override
	public int boardWrite(BoardDto board) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		board.setBip(request.getRemoteAddr());
		return boardDao.boardWrite(board);
	}

	@Override
	public int boardHitUp(int bid) {
		return boardDao.boardHitUp(bid);
	}

	@Override
	public BoardDto boardDetail(int bid) {
		boardHitUp(bid);
		return boardDao.boardDetail(bid);
	}

	@Override
	public void boardReplyPreStep(BoardDto board) {
		boardDao.boardReplyPreStep(board);
	}
	@Override
	public int boardReply(BoardDto board) {
		boardReplyPreStep(board);
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		board.setBip(request.getRemoteAddr());
		return boardDao.boardReply(board);
	}
	@Override
	public int boardModify(BoardDto board) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		board.setBip(request.getRemoteAddr());
		return boardDao.boardModify(board);
	}
	@Override
	public int boardDelete(int bid) {
		return boardDao.boardDelete(bid);
	}

}
