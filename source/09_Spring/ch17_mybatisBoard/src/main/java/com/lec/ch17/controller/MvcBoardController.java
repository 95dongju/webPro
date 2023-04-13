package com.lec.ch17.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch17.dto.BoardDto;
import com.lec.ch17.service.BoardService;
import com.lec.ch17.util.Paging;

@Controller
@RequestMapping("mvcBoard") // 공통요청경로
public class MvcBoardController {
	@Autowired
	private BoardService bservice;
	@RequestMapping(value="list", method= {RequestMethod.GET, RequestMethod.POST})
	public String boardList(String pageNum, Model model) {
		model.addAttribute("boardList", bservice.boardList(pageNum));
		model.addAttribute("paging", new Paging(bservice.boardTotCnt(), pageNum, 10, 10));
		return "mvcBoard/list";
	}
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String boardWrite() {
		return "mvcBoard/write";
	}
	@RequestMapping(value="write", method= RequestMethod.POST)
	public String boardWrite(BoardDto board, Model model) {
		model.addAttribute("writeResult", bservice.boardWrite(board));
		return "forward:list.do";
	}
	@RequestMapping(value="content", method={RequestMethod.GET, RequestMethod.POST})
	public String boardDetail(int bid, Model model) {
		model.addAttribute("contentBoard", bservice.boardDetail(bid));
		return "mvcBoard/content";
	}
	@RequestMapping(value="modify", method=RequestMethod.GET)
	public String boardModify(int bid, Model model) {
		model.addAttribute("board", bservice.boardDetail(bid));
		return "mvcBoard/modify";
	}
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modify(BoardDto board, Model model) {
		model.addAttribute("modifyResult", bservice.boardModify(board));
		return "forward:content.do";
	}
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("deleteResult", bservice.boardDelete(bid));
		return "forward:list.do";
	}
	@RequestMapping(value="reply", method=RequestMethod.GET)
	public String replyView(int bid, Model model) {
		model.addAttribute("board", bservice.boardDetail(bid));
		return "mvcBoard/reply";
	}
	@RequestMapping(value="reply", method= RequestMethod.POST)
	public String reply(BoardDto board, Model model) {
		model.addAttribute("board", bservice.boardReply(board));
		return "forward:list.do";
	}
}
