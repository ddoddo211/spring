<%@page import="kr.or.ddit.user.util.model.PageVo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>
	<%@ include file="/WEB-INF/view/common/basicLib.jsp" %>

</head>

<body>


	<%-- 지시자 --%>
	<%@ include file="/WEB-INF/view/common/header.jsp" %>

	<div class="container-fluid">
		<div class="row">

	<%-- 지시자 --%>
	<%@ include file="/WEB-INF/view/common/left.jsp" %>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

	<%
	
	
	%>


			<form class="form-horizontal" role="form" method="get" action="/prodUpdate?prod_id='${prodVo.prod_id }'">
			
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">상품 사진</label>
                  <div class="col-sm-10">
                  	
                  			<img src="/profile/noimage.jpg"/>
                  </div>
               </div>
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">상품 아이디</label>
                  <div class="col-sm-10">
                     <label for="userNm" class=" control-label">${prodVo.prod_id }</label>
                     <input type="hidden" name="prod_id" value="${prodVo.prod_id }">
                  </div>
               </div>

               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">상품명</label>
                  <div class="col-sm-10">
                     <label class=" control-label">${prodVo.prod_name }</label>
                  </div>
               </div>

               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">상품그룹명</label>
                  <div class="col-sm-10">
                     <label class="control-label">${prodVo.lprod_nm }</label>
                  </div>
               </div>
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">상품설명</label>
                  <div class="col-sm-10">
                     <label class=" control-label">${prodVo.prod_outline }</label>
                  </div>
               </div>
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">가격</label>
                  <div class="col-sm-10">
                     <label class=" control-label">${prodVo.prod_price }</label>
                  </div>
               </div>
               
               
               <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                     <button type="submit" class="btn btn-default">정보 수정</button>
                  </div>
               </div>
                
            </form>
			</div>
		</div>
	</div>

</body>
</html>
