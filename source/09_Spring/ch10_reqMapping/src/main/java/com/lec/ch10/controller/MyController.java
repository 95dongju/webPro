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
//		String method = request.getMethod(); // Get �Ǵ� Post
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
			// �´� id�� �Է��� ��� "studentOk.do" ��û
			return "redirect:studentOk.do"; // studentOk.do�� get������� ��û
			// forward ���� model, parameter �״�� return (POST�� ������ �� ��� �Ұ���)
			// redirect ���� model reset, parameter�� return (POST�� ������ �� ��� ����)
		}else {
			// confirm ���е� id�� �Է��� ��� "studentNg.do" ��û
			return "forward:studentNg.do"; // studentNg.do�� idConfirm ��û ��İ� ���� ������� ��û (studentNg�� �Ѿ���� method�� get, post �� �� ����� ��� ��)
		}
	}
	@RequestMapping(value="fullPath", method=RequestMethod.GET)
	public String fullPath() {
		return "redirect:http://localhost:8090/ch10/temp/fullPath.jsp";
	}
}
