<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.css"></link>
<link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.min.css"></link>
</head>
<body>
<div class="container">
<table>
  <tr>
   <td>
   <form name="writeform" role="form" class="form-horizontal" action="http://localhost:8080/taehoon_free/BoardServlet?key=write" method="post">
    <table width="100%" cellpadding="0" cellspacing="0" border="0">
     <tr style="background:url('../img/table_mid.gif') repeat-x; text-align:center;">
      <td width="5"><img src="../img/table_left.gif" width="5" height="30" /></td>
      <td>글쓰기</td>
      <td width="5"><img src="../img/table_right.gif" width="5" height="30" /></td>
     </tr>
    </table>
    
   <table class="table">
     <tr>
      <td>&nbsp;</td>
      <td align="center">제목</td>
      <td><input type="text" class="form-control" name="bSub" size="50" maxlength="100"></td>
      <td>&nbsp;</td>
     </tr>
    
    <tr>
      <td>&nbsp;</td>
      <td align="center">이름</td>
      <td><input type="text" class="form-control" name="bWriter" size="50" maxlength="50"></td>
      <td>&nbsp;</td>
     </tr>
     
    <tr>
      <td>&nbsp;</td>
      <td align="center">비밀번호</td>
      <td><input type="password" class="form-control" name="bPwd" size="50" maxlength="50"></td>
      <td>&nbsp;</td>
     </tr>
     
     <tr>
      <td>&nbsp;</td>
      <td align="center">내용</td>
      <td><textarea class="form-control" name="bContent" cols="50" rows="13"></textarea></td>
      <td>&nbsp;</td>
     </tr>
     
     <tr>
      <td>&nbsp;</td>
      <td colspan="2"><button type="submit" class="btn btn-success" onClick="javascript:writeCheck();">등록</button>
      <button type="reset" class="btn btn-warning" name="reset">다시 작성</button>
      <button type="button" class="btn btn" onClick="javascript:history.go(-1)">취소</button>
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