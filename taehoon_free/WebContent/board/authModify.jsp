<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kpu.movie.domain.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성자 확인(수정)</title>
<link rel="stylesheet" href="./resources/bootstrap/css/bootstrap.css"></link>
<link rel="stylesheet" href="./resources/bootstrap/css/bootstrap.min.css"></link>
</head>
<body>
<div class="container">
	<form role="form" class="form-horizontal" action="http://localhost:8080/taehoon_free/BoardServlet?key=authToModify&num=${auth_modify.bNum}" method="post">
		<fieldset>
			<legend>작성자 확인</legend>
			<div class="form-group">
				<label class="col-sm-2 control-label">비밀번호: </label>
				<div class="col-sm-10">
				<input type="password" class="form-control" name="pwd" required placeholder="공백없이 입력하세요">
				</div>
			</div>
		</fieldset>
		
		<br>
		<fieldset>
			<button type="button" class="btn btn-danger pull-right" name="취소" onClick="javascript:history.go(-1)">취소</button>
			<button type="submit" class="btn btn-success pull-right" name="submit" >완료</button>
		</fieldset>
	</form>
</div>
</body>
</html>