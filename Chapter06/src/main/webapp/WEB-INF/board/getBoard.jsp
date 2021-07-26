<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>

<h1>Board Detail</h1>
<hr>

<form action="updateBoard" method="post">
<input name="seq" type="hidden" value="${board.seq }" />
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">제목</td>
		<td align="left"><input type="text" name="title" value="${board.title }"/></td>
	</tr>
	<tr>
		<td bgcolor="orange" width="70">작성자</td>
		<td align="left">${board.writer }</td>
	</tr>
	<tr>
		<td bgcolor="orange" width="70">내용</td>
		<td align="left"><textarea name="content" cols="40" rows="10">${board.content }</textarea></td>
	</tr>
	<tr>
		<td bgcolor="orange">등록일</td>
		<td align="left"><fmt:formatDate value="${board.createDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
	</tr>
	<tr>
		<td bgcolor="orange">조회수</td>
		<td align="left">${board.cnt }</td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="글 수정"/></td>
	</tr>
</table>
</form>
<hr>
<a href="insertBoardView">글 등록</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard?seq=${board.seq }">글 삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList">글 목록</a>

</center>
</body>
</html>