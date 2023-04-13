package com.lec.ch17.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch17.dto.BoardDto;

@Mapper
public interface BoardDao {
	public List<BoardDto> boardList(BoardDto board);
	public int boardTotCnt();
	public int boardWrite(BoardDto board);
	public int boardHitUp(int bid);
	public BoardDto boardDetail(int bid);
	public void boardReplyPreStep(BoardDto board);
	public int boardReply(BoardDto board);
	public int boardModify(BoardDto board);
	public int boardDelete(int bid);

}
