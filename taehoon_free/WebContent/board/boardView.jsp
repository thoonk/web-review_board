<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kpu.movie.domain.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 보기</title>
<link rel="stylesheet" href="./resources/bootstrap/css/bootstrap.css"></link>
<link rel="stylesheet" href="./resources/bootstrap/css/bootstrap.min.css"></link>
</head>
<body>
<div class="container">
<table>
  <tr>
   <td>
    <table width="100%" cellpadding="0" cellspacing="0" border="0">
     <tr style="background:url('img/table_mid.gif') repeat-x; text-align:center;">
      <td width="5"><img src="img/table_left.gif" width="5" height="30" /></td>
      <td>내용</td>
      <td width="5"><img src="img/table_right.gif" width="5" height="30" /></td>
     </tr>
    </table>
   <table class="table">
     <tr>
      <td width="0">&nbsp;</td>
      <td align="center" width="76">글번호</td>
      <td width="319">${boardDetail.bNum}</td>
      <td width="0">&nbsp;</td>
     </tr>
	
    <tr>
      <td width="0">&nbsp;</td>
      <td align="center" width="76">조회수</td>
      <td width="319">${boardDetail.bHit}</td>
      <td width="0">&nbsp;</td>
     </tr>
	
    <tr>
      <td width="0">&nbsp;</td>
      <td align="center" width="76">글쓴이</td>
      <td width="319">${boardDetail.bWriter}</td>
      <td width="0">&nbsp;</td>
     </tr>
    
    <tr>
      <td width="0">&nbsp;</td>
      <td align="center" width="76">작성일</td>
      <td width="319">${boardDetail.bDate}</td>
      <td width="0">&nbsp;</td>
     </tr>
   
    <tr>
      <td width="0">&nbsp;</td>
      <td align="center" width="76">제목</td>
      <td width="319">${boardDetail.bSub}</td>
      <td width="0">&nbsp;</td>
     </tr>
   
                <tr>
      <td width="0">&nbsp;</td>
                   <td width="399" colspan="2" height="200">${boardDetail.bContent}
                </tr>
     <tr align="center">
      <td width="0">&nbsp;</td>
      <td colspan="2" width="399">
      <div class="parent">
      	<div class="third">
	    <button type="button"  class="btn btn-dark"  onClick="location.href='http://localhost:8080/taehoon_free/BoardServlet?key=list'" >목록</button>
	    </div>
	    <div class="second">
	    <form action ="http://localhost:8080/taehoon_free/BoardServlet?key=auth_modify&num=${boardDetail.bNum}" method="post">	
			<button type=submit class="btn btn-success">수정</button>
		</form></div>
		<div class="first">
		<form action ="http://localhost:8080/taehoon_free/BoardServlet?key=auth_delete&num=${boardDetail.bNum}" method="post">	
			<button type=submit class="btn btn-danger">삭제</button>
		</form>
		</div>
	  </div>
	
      <td width="0">&nbsp;</td>
     </tr>
    </table>
   </td>
  </tr>
 </table>
</div>
</body>
</html>