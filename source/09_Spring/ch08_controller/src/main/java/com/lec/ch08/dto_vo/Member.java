package com.lec.ch08.dto_vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
// getter, setter
@AllArgsConstructor 
// �Ű����� �ִ� ������ �Լ�
@NoArgsConstructor 
// �Ű����� ���� ������ �Լ�
public class Member {
	private String id;
	private String pw;
	@Override
	public String toString() {
		return "Member: ���̵�� " +id+ ", ��й�ȣ�� " +pw;
	}
}
