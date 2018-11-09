<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <c:set var="userId"> --%>
<%-- 	<c:choose> --%>
<%-- 		<c:when test="${userVo.userId==null }"> --%>
			
<%-- 		</c:when> --%>
<%-- 		<c:otherwise> --%>
<%-- 			${userVo.userId } --%>
<%-- 		</c:otherwise> --%>
<%-- 	</c:choose> --%>
<%-- </c:set> --%>

	<h2>view.jsp</h2>
	<form action="/validator/validate" method="post">
												<%--{param.userId} 로도 가능 (컨트롤러에서 VO다시 안넘겨도 됨) --%>
		ID<input type="text" name="userId" value="${userVo.userId }" /> <form:errors path="userVo.userId"/> <br/>
		NM<input type="text" name="name" value="${userVo.name }" />  <form:errors path="userVo.name"/> <br/>
		PW<input type="password" name="pass"  /> <form:errors path="userVo.pass"/> <br/>
		<input type="submit" value="전송"/> <br/>
	</form>
	
	
	<h2>view.jsp-jsr303</h2>
	<form action="/validator/validateJsr" method="post">
												<%--{param.userId} 로도 가능 (컨트롤러에서 VO다시 안넘겨도 됨) --%>
		ID<input type="text" name="userId" value="${param.userId }" /> <form:errors path="userVoJsr303.userId"/>  <br/>
		NM<input type="text" name="name" value="${param.name }" />  <form:errors path="userVoJsr303.name"/> <br/>
		PW<input type="password" name="pass"  /> <form:errors path="userVoJsr303.pass"/> <br/>
		<input type="submit" value="전송"/> <br/>
	</form>

</body>
</html>