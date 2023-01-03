package com.lec.ex1_string;

public class Ex09_StringBuffer {
	public static void main(String[] args) {
		String str = "abc";
		// 변경이 잦은 경우 String 버퍼 사용함
		
		StringBuffer strBuffer = new StringBuffer ("abc");
		System.out.println("strBuffer의 해쉬코드 : " +strBuffer.hashCode());
		
		strBuffer.append("def");
		System.out.println("append 후 :" +strBuffer);
		
		System.out.println("strBuffer의 수정된 해쉬코드 : " +strBuffer.hashCode());
		// String은 해쉬코드가 바뀜. 하지만 StringBuffer는 수정해도 해쉬코드가 바뀌지 않음.
		
		
		strBuffer.insert(3,"aaa"); //3번째에 aaa 추가
		System.out.println("insert 후: " +strBuffer);
		
		strBuffer.delete(3, 6); // 3번째부터 6번째 앞까지
		System.out.println("delete 후: " +strBuffer);
		
		int capacitySize = strBuffer.capacity(); // 버퍼의 가용크기
		System.out.println("버퍼의 가용크기는: " +capacitySize);
		
		strBuffer.append("abcdefghijklmnopqrstuvwxyz0123456789");
		System.out.println("append 후: " +strBuffer);
		
		int capacitySize2 = strBuffer.capacity();
		System.out.println("버퍼의 가용크기는: " +capacitySize2);
		System.out.println("해쉬코드 : " +strBuffer.hashCode());
	}
}
