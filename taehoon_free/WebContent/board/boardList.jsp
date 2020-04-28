<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kpu.movie.domain.*, java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" href="./resources/bootstrap/css/bootstrap.min.css"></link>
<link rel="stylesheet" href="./resources/bootstrap/css/bootstrap.css"></link>
</head>
<body>
	<div class="container">
	<table class="table table-striped">
		<caption>팝팝 <영화 게시판></caption>
			<tr>
				<td>번호</td>
				<td>제목</td> 
				<td>글쓴이</td>
				<td>날짜</td>
				<td>조회</td> 
			</tr>
			<c:forEach var="vo" items="${boardList}">
			<tr>
				<td>${vo.bNum}</td>
				<td>
				<a href="http://localhost:8080/taehoon_free/BoardServlet?key=showView&num=${vo.bNum}" target="_self">${vo.bSub}</a></td>
				<td>${vo.bWriter}</td>
				<td>${vo.bDate}</td>	
				<td>${vo.bHit}</td>	
			</tr>				
			</c:forEach>		
	</table>
	<form action ="http://localhost:8080/taehoon_free/BoardServlet?key=startWrite" method="post">	
		<button type="submit" class="btn btn pull-right" name="submit">글쓰기 </button>
	</form>
	</div>
</body>
</html>