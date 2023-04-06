package com.lec.student.vo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.student.Student;

@Controller
public class StudentController {
	@ModelAttribute("cnt")
	public int cnt() {
		int cnt = 4;
		return cnt;
	}
	@RequestMapping(value="input.do", method=RequestMethod.POST)
	public String input(Student student) {
		return "student/input";
	}
	@RequestMapping(value="input.do", method=RequestMethod.GET)
	public String result(Student student) {
		return "student/result";
	}
}
