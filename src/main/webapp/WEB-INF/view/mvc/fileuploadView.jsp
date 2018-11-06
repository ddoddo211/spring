<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>fileupload view</h2>
<hr/>
<form action="/mvc/fileupload" method="post" enctype="multipart/form-data">
	첨부할 파일  : <input type="file" name="uploadFile"/>				<br/><br/>
	사용자 아이디: <input type="text" name="userId" value="brown"/>    <br/><br/>
	<input type="submit" value="전송"/>                 <br/>
</form>
</body>
</html>