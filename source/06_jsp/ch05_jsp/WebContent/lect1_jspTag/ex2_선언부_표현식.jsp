<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<!-- HTML 주석 -->
<%-- JSP 주석 (source에서 감출 수 있음) --%>
<% // Scriptlet 안에서 JAVA 주석 가능함
	int j=0; // Scriptlet 에서는 변수를 선언하고 초기화하지 않으면 더미 데이터가 들어 있기 때문에 사용 불가능. int j; XX
	StringBuffer strBuf1 = new StringBuffer("scriptlet에서 선언한 메소드입니다");
	i++; j++;
	strBuf.append("<span> ♡  </span>");
	strBuf1.append("<span> ♡ </span>");
	out.print("지역변수 j = " + j + "<br>");
	out.print("strBuf1 = " + strBuf1 + "<br>");
	out.print("전역변수 i = " + i + "<br>");
	out.print("strBuf = " + strBuf + "<br>");
	out.print("sum(3,4) = " +sum(3,4));
%>

<%-- 지역 변수: <%=j %><br> <!-- scriptlet 내에서 선언한 변수는 반드시 선언한 후 아래에서 사용해야 함 --> --%>
<%-- 전역 변수: <%=i %><br> <!-- 선언부에서 선언된 변수는 전역 변수 --> --%>
<%-- 지역 변수는 실행할 때마다 새로 생성되며, 전역 변수는 브라우저를 꺼도 메모리에 계속 남아있음 --%>

<%! // 선언부 (전역변수, 메소드 선언 가능) (중요한 변수로써 선언함)
	int i; // 초기화하지 않아도 수는 0, 객체는 null로 자동 초기화 됨
	// String 변수는 메모리를 과부화시키기 때문에 자주 바뀌는 변수는 StringBuffer 사용함
	StringBuffer strBuf = new StringBuffer("Good");
	private int sum(int a, int b){
		return a+b;
	}
%>
</body>
</html>