<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:forEach items="${userList }" var="ul" varStatus="status">
	<tr class="userClick">
		<td>${status.index+1}</td>
		<td>${ul.userId}</td>
		<td>${ul.name }</td>
		<td><fmt:formatDate value="${ul.birth}" pattern="yyyy-MM-dd" /></td>
	</tr>	
</c:forEach>