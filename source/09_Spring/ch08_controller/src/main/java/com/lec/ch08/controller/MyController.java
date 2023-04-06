package com.lec.ch08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	// http://localhost:8090/ch08/
	@RequestMapping("/")
	public String home(/* Model model */) {
		// request.setAttribute("greeting", "�ȳ�, ������!"); --> ${greeting}
		// model.addAttribute("greeting", "�ȳ�, ������!");
		return "main"; // view : model�� �Բ� ���� "/WEB-INF/views/" + "main"+".jsp"
	}
}
