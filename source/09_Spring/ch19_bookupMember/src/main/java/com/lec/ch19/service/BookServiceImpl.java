package com.lec.ch19.service;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dao.BookDao;
import com.lec.ch19.util.Paging;
import com.lec.ch19.vo.Book;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	String backupPath = "C:\\JU\\source\\09_Spring\\ch19_bookupMember\\src\\main\\webapp\\bookImgFileUpload\\";
	@Override
	public List<Book> mainList() {
		return bookDao.mainList();
	}

	@Override
	public List<Book> bookList(String pageNum) {
		Paging page = new Paging(bookDao.totCntBook(), pageNum, 3, 3);
		Book book = new Book();
		book.setStartRow(page.getStartRow());
		book.setEndRow(page.getEndRow());
		return bookDao.bookList(book);
	}

	@Override
	public Book getDetailBook(int bnum) {
		return bookDao.getDetailBook(bnum);
	}

	@Override
	public int registerBook(MultipartHttpServletRequest mRequest, Book book) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames();
		String[] bimg = {"", ""};
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param);
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx]!=null && !bimg[idx].equals("")) {
				if(new File(uploadPath+bimg[idx]).exists()) {
					bimg[idx] = System.currentTimeMillis() + "_" +bimg[idx];
				}
				try {
					mFile.transferTo(new File(uploadPath+bimg[idx]));
					System.out.println("서버파일 - " + uploadPath+bimg[idx]);
					System.out.println("백업파일 - " + backupPath+bimg[idx]);
				}catch(IOException e) {
					System.out.println(e.getMessage());
				}
			}else {
				bimg[idx] = "";
			}
			idx++;
		}
		book.setBimg1(bimg[0]);
		book.setBimg1(bimg[1]);
		return bookDao.registerBook(book);
	}

	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames();
		String[] bimg = {"", ""};
		int idx = 0;
		while(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param);
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx]!=null && !bimg[idx].equals("")) {
				if(new File(uploadPath+bimg[idx]).exists()) {
					bimg[idx] = System.currentTimeMillis() + "_" +bimg[idx];
				}
				try {
					mFile.transferTo(new File(uploadPath+bimg[idx]));
					System.out.println("서버파일 - " + uploadPath+bimg[idx]);
					System.out.println("백업파일 - " + backupPath+bimg[idx]);
				}catch(IOException e) {
					System.out.println(e.getMessage());
				}
			}else {
				bimg[idx] = "";
			}
			idx++;
		}
		book.setBnum(Integer.parseInt(mRequest.getParameter("bnum")));
		book.setBtitle(mRequest.getParameter("btitle"));
		book.setBwriter(mRequest.getParameter("bwriter"));
		book.setBrdate(Date.valueOf(mRequest.getParameter("brdate")));
		book.setBinfo(mRequest.getParameter("binfo"));
		book.setBimg1(bimg[0]);
		book.setBimg1(bimg[1]);
		return bookDao.registerBook(book);
	}

	@Override
	public int totCntBook() {
		return bookDao.totCntBook();
	}
}
