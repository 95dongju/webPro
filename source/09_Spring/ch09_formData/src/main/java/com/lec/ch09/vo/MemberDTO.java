package com.lec.ch09.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
// getter, setter
@AllArgsConstructor 
// 매개변수 있는 생성자 함수
@NoArgsConstructor 
// 매개변수 없는 생성자 함수
public class MemberDTO {
	private String name;
	private String id;
	private String pw;
	private int age;
	private String email;
	private String address;
}
