package com.lec.ch08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// "board/write", "board/content", "board/list", "board/reply"
@Controller

@RequestMapping("board")
// board => 공통 요청 경로는 위에 선언
public class BoardController {
	@RequestMapping(value="write")
	public String write() {
		return "board/write"; // view: "WEB-INF/views/board/write.jsp"
	}
	@RequestMapping(value="content") 
	
}
