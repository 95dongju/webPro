package com.lec.ch08.dto_vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
// getter, setter
@AllArgsConstructor 
// 매개변수 있는 생성자 함수
@NoArgsConstructor 
// 매개변수 없는 생성자 함수
public class Member {
	private String id;
	private String pw;
	@Override
	public String toString() {
		return "Member: 아이디는 " +id+ ", 비밀번호는 " +pw;
	}
}
