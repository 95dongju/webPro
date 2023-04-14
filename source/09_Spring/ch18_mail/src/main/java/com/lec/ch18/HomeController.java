package com.lec.ch18;


import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private JavaMailSender mailSender;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("회원가입 페이지로");
		return "join";
	}
	@RequestMapping(value="textMail", method=RequestMethod.POST)
	public String textMail(String name, String email, Model model) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email); // 받을 메일 주소
		message.setSubject("[TEXT 가입 감사]" + name + "님 회원가입 감사합니다"); // 받을 메일 제목
		String content = name + "님 회원가입 감사합니다 \n <h1>태그 안 먹힘</h1>";
		message.setText(content); // 메일 본문 내용
		mailSender.send(message); // 메일 발송
		model.addAttribute("mailSendResult", "TEXT 메일 발송 성공");
		return "sendResult";
	}
	@RequestMapping(value="htmlMail", method=RequestMethod.POST)
	public String htmlMail(final String name, final String email, Model model) {
		MimeMessagePreparator message = new MimeMessagePreparator() {
			String content = "<div style=\"width:500px; margin:0 auto\">\n" + 
					"		<h1>"+name+"님 회원가입 감사합니다</h1>\n" + 
					"		<p>아무개 사이트에서만 사용 가능한 감사 쿠폰입니다</p>\n" + 
					"		<p><img src=\"https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png\"></p>\n" + 
					"		<hr color=\"red\">\n" + 
					"		<p style=\"color:red;\">빨간 글씨 부분</p>\n" + 
					"		<p style=\"color:blue;\">파란 글씨 부분</p>\n" + 
					"		<p><img src=\"http://localhost:8090/ch18/img/coupon.jpg\" alt=\"쿠폰\"></p>\n" + 
					"		<p align=\"center\">서울시 어떤구 몰라17길 51 어떤빌딩 2층</p>\n" + 
					"	</div>";
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// 받을 메일
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
				// 보낼 메일
				mimeMessage.setFrom(new InternetAddress("95.dongju@gmail.com"));
				// 메일 제목
				mimeMessage.setSubject("[HTML 가입 인사]" + name + "님 가입 감사합니다");
				// 메일 본문
				mimeMessage.setText(content, "utf-8", "html");
			}
		};
		mailSender.send(message);
		model.addAttribute("mailSendResult", "HTML 메일 발송 성공");
		return "sendResult";
	}
}
