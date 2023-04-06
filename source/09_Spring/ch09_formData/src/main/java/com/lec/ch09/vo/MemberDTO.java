package com.lec.ch09.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
// getter, setter
@AllArgsConstructor 
// �Ű����� �ִ� ������ �Լ�
@NoArgsConstructor 
// �Ű����� ���� ������ �Լ�
public class MemberDTO {
	private String name;
	private String id;
	private String pw;
	private int age;
	private String email;
	private String address;
}
