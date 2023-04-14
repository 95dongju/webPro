package com.lec.ch19.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.lec.ch19.dao.MemberDao;
import com.lec.ch19.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private JavaMailSender mailSender;
	@Override
	public int idConfirm(String mid) {
		return memberDao.idConfirm(mid);
	}

	@Override
	public int joinMember(final Member member, HttpSession httpSession) {
		MimeMessagePreparator message = new MimeMessagePreparator() {
		String content = "<div style=\"width:500px; margin:0 auto\">\n" + 
				"		<h1>"+member.getMname()+"님 회원가입 감사합니다</h1>\n" + 
				"		<p>아무개 사이트에서만 사용 가능한 감사 쿠폰입니다</p>\n" + 
				"		<p><img src=\"https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png\"></p>\n" + 
				"		<hr color=\"red\">\n" + 
				"		<p style=\"color:red;\">빨간 글씨 부분</p>\n" + 
				"		<p style=\"color:blue;\">파란 글씨 부분</p>\n" + 
				"		<p><img src=\"http://localhost:8090/ch19/img/coupon.jpg\" alt=\"쿠폰\"></p>\n" + 
				"		<p align=\"center\">서울시 어떤구 몰라17길 51 어떤빌딩 2층</p>\n" + 
				"	</div>";
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(member.getMmail()));
				mimeMessage.setFrom(new InternetAddress("95.dongju@gmail.com"));
				mimeMessage.setSubject(member.getMname()+"님 회원가입 감사합니다");
				mimeMessage.setText(content, "utf-8", "html");
			}
		};
		mailSender.send(message);
		httpSession.setAttribute("mid", member.getMid());
		return memberDao.joinMember(member);
	}

	@Override
	public Member getDetailMember(String mid) {
		return memberDao.getDetailMember(mid);
	}

	@Override
	public String loginCheck(String mid, String mpw, HttpSession httpSession) {
		String result = "로그인 성공";
		Member member = memberDao.getDetailMember(mid);
		if(!member.getMid().equals(mid)) {
			result = "유효하지 않은 아이디입니다.";
		}else if(!member.getMpw().equals(mpw)) {
			result = "비밀번호를 확인하세요";
		}else {
			httpSession.setAttribute("member", member);
			httpSession.setAttribute("mid", mid);
		}
		return null;
	}

	@Override
	public int modifyMember(Member member) {
		return memberDao.modifyMember(member);
	}

}
