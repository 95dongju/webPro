package com.lec.ex1_string;

public class Ex02_StringApiMethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("abcXabc");
		String str3 = "  ja  va  ";
		System.out.println("1."+str1.concat(str2)); //									1. abcXabcabcXabc
		System.out.println("2."+str1.substring(3)); // n번째부터 끝까지 						2. Xabc
		System.out.println("3."+str1.substring(3,5)); // n번째부터 n번째 앞까지 				3. Xa
		System.out.println("4."+str1.length()); // 문자열 길이     							4. 7
		System.out.println("5."+str1.toUpperCase()); //대문자로    							5. ABCXABC
		System.out.println("6."+str1.toLowerCase()); //소문자로    							6. abcxabc
		System.out.println("7."+str1.charAt(3)); // n번째 문자     							7. X
		System.out.println("8."+str1.indexOf('b')); //첫번째 b가 나오는 인덱스 					8. 1
		System.out.println("9."+str1.lastIndexOf("b")); //마지막 b가 나오는 인덱스 				9. 5
		String str4 = "abcXabcXabcXabc@"; // 3, 7, 9 로 반복
		System.out.println("10."+str4.indexOf("b", 3)); //n번째 인텍스부터 나오는 첫 b를 찾음 		10. 5
		System.out.println("11."+str4.indexOf("cXa")); // 처음 나오는 cXa의 인덱스				11. 2
		System.out.println("12."+str4.indexOf("cXa", 9)); // n번째부터 나오는 첫 cXa			12. 10
		System.out.println("13."+str4.indexOf("@")); // 없으면 -1							13. -1
		System.out.println("14."+str1.equals(str2)); // 같은 스트링은 true					14. true
		System.out.println("15."+str1.equalsIgnoreCase("abcxabc")); //대소문자 구별없이 비교	15. true
		System.out.println("16."+str3.trim()); //앞뒤 스페이스 제거 ltrim 왼쪽 rtrim 오른쪽		16. ja va
		System.out.println("17."+str4.replace("abc", "def")); //abc를 def로 바꿈			17.defXdefXdefXdef@
		System.out.println("str1 = " +str1);
	}
}
