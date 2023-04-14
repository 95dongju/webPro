package com.lec.ch19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch19.dao.BookDao;
import com.lec.ch19.vo.Book;

@Controller
@RequestMapping(value="book")
public class BookController {
	@Autowired
	private BookDao bookDao;
	@RequestMapping(params="method=register", method=RequestMethod.GET)
	public String registerBook() {
		return "book/register";
	}
	@RequestMapping(params="method=register", method=RequestMethod.POST)
	public String registerBook(Book book, Model model) {
		model.addAttribute("registerResult", bookDao.registerBook(book));
		return "book/list";
	}
}
