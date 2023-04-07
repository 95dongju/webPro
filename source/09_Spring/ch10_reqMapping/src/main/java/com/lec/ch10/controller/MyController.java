package com.lec.ch10.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping(value="main", method=RequestMethod.GET) // value="/main" or value="main.do"
	public String main() {
		return "main";
	}
//	@RequestMapping("student")
//	public String student(String id, Model model, HttpServletRequest request) {
//		String method = request.getMethod(); // Get 또는 Post
//		model.addAttribute("method", method);
//		model.addAttribute("id", id);
//		return "studentId";
//	}
	@RequestMapping(value="student", method=RequestMethod.GET)
	public String student(String id, Model model) {
		model.addAttribute("method", "GET");
		model.addAttribute("id", id);
		return "studentId";
	}
	@RequestMapping(value="student", method=RequestMethod.POST)
	public ModelAndView student(String id, ModelAndView mav) {
		mav.addObject("method", "POST");
		mav.addObject("id", id);
		mav.setViewName("studentId");
		return mav;
	}
	@RequestMapping(value="studentOk", method=RequestMethod.GET)
	public String studentOk() {
		return "studentOk";
	}
	@RequestMapping(value="studentNg", method=RequestMethod.GET)
	public String studentNg() {
		return "studentNg";
	}
	@RequestMapping(value="studentNg", method=RequestMethod.POST)
	public String studentNgPost() {
		return "studentNg";
	}
	@RequestMapping(value="idConfirm", method=RequestMethod.POST)
	public String idConfirm(String id, Model model) {
		model.addAttribute("id", id);
		if(id.equals("aaa")) {
			// 맞는 id를 입력한 경우 "studentOk.do" 요청
			return "redirect:studentOk.do"; // studentOk.do를 get방식으로 요청
			// forward 사용시 model, parameter 그대로 return (POST로 전송할 때 사용 불가능)
			// redirect 사용시 model reset, parameter만 return (POST로 전송할 때 사용 가능)
		}else {
			// confirm 실패된 id를 입력한 경우 "studentNg.do" 요청
			return "forward:studentNg.do"; // studentNg.do를 idConfirm 요청 방식과 같은 방식으로 요청 (studentNg로 넘어오는 method를 get, post 둘 다 만들어 줘야 함)
		}
	}
	@RequestMapping(value="fullPath", method=RequestMethod.GET)
	public String fullPath() {
		return "redirect:http://localhost:8090/ch10/temp/fullPath.jsp";
	}
}
