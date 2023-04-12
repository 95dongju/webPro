package com.lec.ch11.service;
import java.util.List;

import com.lec.ch11.dto.BoardDto;

public interface BoardService {
	public List<BoardDto> boardList(BoardDto board);
	public int boardTotCnt();
	public int boardWrite(BoardDto board);
	public int boardHitUp(int bid);
	public BoardDto boardDetail(int bid);
	public int boardReplyPreStep(BoardDto board);
	public int boardReply(BoardDto board);
	public int boardModify(BoardDto board);
	public int boardDelete(int bid);
}