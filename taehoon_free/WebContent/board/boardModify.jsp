<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kpu.movie.domain.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<link rel="stylesheet" href="./resources/bootstrap/css/bootstrap.css"></link>
<link rel="stylesheet" href="./resources/bootstrap/css/bootstrap.min.css"></link>
</head>
<body>
<div class="container">
<table>
  <tr>
   <td>
    <form role="form" class="form-horizontal" action ="http://localhost:8080/taehoon_free/BoardServlet?key=modify&num=${modify.bNum}" method="post">	
    <table width="100%" cellpadding="0" cellspacing="0" border="0">
     <tr style="background:url('img/table_mid.gif') repeat-x; text-align:center;">
      <td width="5"><img src="img/table_left.gif" width="5" height="30" /></td>
      <td>수정</td>
      <td width="5"><img src="img/table_right.gif" width="5" height="30" /></td>
     </tr>
    </table>
    
   <table class="table">
     <tr class="form-group">
      <td>&nbsp;</td>
      <td align="center">제목</td>
      <td class="col-sm-10"><input class="form-control" name="sub" size="50" maxlength="100" value="${modify.bSub}"></td>
      <td>&nbsp;</td>
     </tr>
    
    <tr class="form-group">
      <td>&nbsp;</td>
      <td align="center">작성자</td>
      <td class="col-sm-10"><input class="form-control" name="writer" readonly size="50" maxlength="50" value="${modify.bWriter}"></td>
      <td>&nbsp;</td>
     </tr>
    
     <tr class="form-group">
      <td>&nbsp;</td>
      <td align="center">내용</td>
      <td class="col-sm-10"><textarea class="form-control" name="content" cols="50" rows="13" >${modify.bContent}</textarea></td>
      <td>&nbsp;</td>
     </tr>
   
     <tr class="form-group">
      <td>&nbsp;</td> 
      <td colspan="2">
      <button type="button" class="btn btn-danger pull-right" onClick="javascript:history.go(-1)">취소</button>
       <button type=submit class="btn btn-success pull-right">완료</button>
      <td>&nbsp;</td>
     </tr>
    </table>
    </form>
   </td>
  </tr>
 </table>
</div>
</body>
</html>