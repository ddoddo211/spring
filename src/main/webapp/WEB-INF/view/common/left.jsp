<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-sm-3 col-md-2 sidebar">
	<form action="/userAllList" method="get">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="/main.jsp">Main <span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="/userAllList?pageNum=1">사용자리스트</a></li>
		<li class="active"><a href="/userPageList">사용자페이지리스트</a></li>
		<li class="active"><a href="/prodList">상품목록</a></li>
		<!-- 사용자 리스트 클릭시 : jspuser 전체 정보를 조회하여 화면에 출력 
			
			0. 요청을 처리할 서블릿을 생성한다 : UserServlet
			1. jspuser 전체 정보 조회 : userService.selectUserAll() 만들어놓은것 사용
			2. 사용자 정보를 화면에 출력할 jsp(화면) : userAllList.jsp
			
		-->
	</ul>
		<input type="hidden" name="pageNum" value="1"/>
	</form>
</div>