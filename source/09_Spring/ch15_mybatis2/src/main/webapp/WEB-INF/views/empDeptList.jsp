<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/emp.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script>
		$(document).ready(function(){
			$('tr').click(function(){
				let empno = Number($(this).children().eq(0).text().trim());
				if(! isNaN(empno)){
					location.href='${conPath}/detail.do?empno='+empno+'&pageNum=${paging.currentPage}';
				}
			});
		});
		const trClicked = empno=>{
			// 해당 사원번호의 상세보기 페이지로 이동
			location.href='${conPath}/detail.do?empno='+empno+'&pageNum=${paging.currentPage}';
		};
	</script>
</head>
<body>
	<c:set var="success" value="1"/>
	<c:if test="${deleteResult eq success }">
		<script>
			alert('성공적으로 삭제되었습니다.');
		</script>
	</c:if>
	<table>
		<caption>직원목록</caption>
		<tr>
			<td colspan="5">
				<a href="${conPath }/writeView.do">직원 등록</a>
			</td>
		</tr>
		<tr>
			<th>사번</th><th>이름</th><th>업무</th><th>부서명</th><th>근무지</th>
		</tr>
		<c:if test="${paging.totCnt == 0 }">
		<tr>
			<td colspan="5">해당 사원이 없습니다</td>
		</tr>
		</c:if>
		<c:forEach items="${empDeptList }" var="empDept">
			<tr onclick="trClicked(${empDept.empno })">
				<td>${empDept.empno }</td>
				<td>${empDept.ename }</td>
				<td>${empDept.job }</td>
				<td>${empDept.dname }</td>
				<td>${empDept.loc }</td>
			</tr>
		</c:forEach>
	</table>
	<div id="paging">
		<c:if test="${paging.startPage > paging.blockSize }">
			[<a href="${conPath }/empDeptList.do?pageNum=${paging.startPage-1}">이전</a>]
		</c:if>
		<c:forEach var="i" begin="${paging.startPage }" end="${paging.endPage }">
			<c:if test="${i eq paging.currentPage }">
				[<b>${i }</b>]
			</c:if>
			<c:if test="${i != paging.currentPage }">
				[<a href="${conPath }/empDeptList.do?pageNum=${i}">${i }</a>]
			</c:if>
		</c:forEach>
		<c:if test="${paging.endPage < paging.pageCnt }">
			[<a href="${conPath }/empDeptList.do?pageNum=${paging.endPage+1}">다음</a>]
		</c:if>
	</div>
</body>
</html>