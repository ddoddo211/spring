<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<fmt:parseNumber var="max" value="${totalCnt/10 }" integerOnly="true"/>
	<li><a href='javascript:getUserList("1")'>start</a></li>
	
	<c:forEach begin="0" end="${max }" var="i">
		<c:choose>
			<c:when test="${page==(i+1) }">
				<li><a href='javascript:getUserList(${i+1 })' style="background:#428bca; color:white;">${i+1 }</a></li>
			</c:when>
			<c:otherwise>
				<li><a href='javascript:getUserList(${i+1 })'>${i+1 }</a></li>
			</c:otherwise>
		</c:choose>
	
	</c:forEach>
	
	
	<li><a href='javascript:getUserList(${max })'>end</a></li>
	
