package com.lec.ex2_date;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.lec.ex4_object.Friend;

public class Ex05_FriendBirth {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("홍길동", "010-9999-9999", "12-14","서울 서대문"),
				new Friend("김길동", "010-8888-8888", "12-14","수원 영통"),
				new Friend("신길동", "010-7777-7777", "02-10","서울 용산"),
				new Friend("마길동", "010-6666-6666", "03-03","인천 송도")};
		GregorianCalendar now = new GregorianCalendar(); // now변수에 '지금'이 들어감
		int month = now.get(Calendar.MONTH)+1; 
		int day = now.get(Calendar.DAY_OF_MONTH);
		String monthStr = month<10 ? "0"+month : ""+month; // 정수
		// monthStr = month<10 ? "0"+month : ""+String.valueOf(month); // int를 스트링으로 바꾸는 함수
		//String str = 1+"s"; // 정수랑 스트링이랑 더하면 스트링이 됨
		String dayStr = day < 10 ? "0" +day : ""+day;
		String today = monthStr + "-" + dayStr;
//		System.out.println(today);
		boolean none = true; // 기본적으로는 없다. 하나라도 있으면 none에 false
		System.out.println("오늘 생일자를 검색합니다");
		for (int idx = 0; idx < friends.length ; idx++) {
			String birth = friends[idx].getBirth();
			if (today.equals(birth)) { // today는 객체기 때문에 equals 사용
				System.out.println(friends[idx]);
				none = false; // 한명 이상 출력시 none은 false가 됨 / 한번도 if문 안으로 안 들어왔다는 것은 "오늘 생일자가 없음"
			}//if
		}//for	
		if(none) { //none이 true면, (if문을 안 돌면)
			System.out.println("-오늘 생일자가 없음-");
		}
	}//main
}//class
