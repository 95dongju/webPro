package com.lec.ch08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	// http://localhost:8090/ch08/
	@RequestMapping("/")
	public String home(/* Model model */) {
		// request.setAttribute("greeting", "안녕, 스프링!"); --> ${greeting}
		// model.addAttribute("greeting", "안녕, 스프링!");
		return "main"; // view : model과 함께 전달 "/WEB-INF/views/" + "main"+".jsp"
	}
}
