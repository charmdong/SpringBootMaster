<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
</head>
<body>

<center>
<h1>Board List</h1>
<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<th bgcolor="orange" width="100">번호</th>
	<th bgcolor="orange" width="200">제목</th>
	<th bgcolor="orange" width="150">작성자</th>
	<th bgcolor="orange" width="150">등록일</th>
	<th bgcolor="orange" width="100">조회수</th>
</tr>

<c:forEach var="board" items="${boardList}">
<tr>
	<td>${board.seq }</td>
	<td align="left"><a href="getBoard?seq=${board.seq}">${board.title }</a></td>
	<td>${board.writer }</td>
	<td><fmt:formatDate value="${board.createDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
	<td>${board.cnt} </td> 
</tr>
</c:forEach>

</table>
<br>
<a href="insertBoardView">새글 등록</a>

</center>
</body>
</html>