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
<!-- daum api -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<!--  jquery 달력 api -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<%
	//attribute 에서 VO 받아오기
	UserVo userVo = (UserVo)request.getAttribute("userVo");
%>




</head>

<body>


	<%-- 지시자 --%>
	<%@ include file="/WEB-INF/view/common/header.jsp" %>

<script>

$(document).ready(function(){
	//개발과정에서 설정한 기본값 설정
	<%--
	$("#userId").val("<%=userVo.getUserId()%>");
	$("#pass").val();
	$("#passChk").val();
	$("#name").val("<%=userVo.getName()%>");
   	$("#zipcd").val("<%=userVo.getZipcd()%>");
	$("#addr1").val("<%=userVo.getAddr1()%>");
   	$("#addr2").val("<%=userVo.getAddr2()%>");
   	$("#birth").val("<%=userVo.getBirth()%>");
   	$("#email").val("<%=userVo.getEmail()%>");
   	$("#tel").val("<%=userVo.getTel()%>");
   	--%>
	$("#userId").attr("readonly",true);
   	
   	$("#chkOk").hide();
   	
	//주소, 우편번호 입력창 속성 부여 readonly
	$("#addr1").attr("readonly",true);
   	$("#zipcd").attr("readonly",true);
   	
   	$( function() {
   	    $("#birth").datepicker({
	   	    changeMonth: true,
	   	    changeYear: true,
	   	  	yearRange: "1930:2020",
   	  		dateFormat: "yy-mm-dd"
   	    });
   	  } );
   	
	//주소 검색 버튼 이벤트 핸들러
	$("#addrSearchBtn").click(function(){
	//주소검색 버튼 클릭이벤트가 발생 했을때 실행
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	           	console.log(data);
	            //data >> jason 형식으로 따라온다
	            //주소 : roadAddress
	            //상세주소 : ""
	            //우편번호 : zonecode
	            
	            //주소 input value 설정 : data.roadAddress
	            //우편번호 input value 설정 : data.zonecode
	           	console.log(data.roadAddress);
	           	console.log(data.zonecode);
	           	$("#addr1").val(data.roadAddress);
	           	$("#zipcd").val(data.zonecode);
	        }
	    }).open();
		
	}); // 클릭이벤트 종료
	var cnt = 0;
		$("#passChk").keyup(function(){
			var pass = $("#pass").val();
			var passChk = $("#passChk").val();
			if(pass!=passChk){
				$("#chkOk").show();
			} else {
				$("#chkOk").hide();
			}	
		});
			
		
}); // document.ready 종료

</script>
	<div class="container-fluid">
		<div class="row">

	<%-- 지시자 --%>
	<%@ include file="/WEB-INF/view/common/left.jsp" %>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<form class="form-horizontal" role="form" action="/user/userUpdate" method="post"
				enctype="multipart/form-data" >
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
                  <div class="col-sm-10">
                  		<c:choose>
                  		<c:when test="${userVo.profile!=null}">
                  			<img src="${userVo.profile}"/>
                  		</c:when>
                  		<c:otherwise>
                  			<img src="/profile/noimage.jpg"/>
                  		</c:otherwise>
                  	</c:choose>
                  		<input type="file" name="profilePic" >
                  </div>
               </div>
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
                  <div class="col-sm-10">
                  	<input type="text" class="form-control" id="userId" name="userId"
                  		placeholder="사용자 아이디" value="${userVo.userId }">
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">비밀번호</label>
                  <div class="col-sm-10">
                  	<input type="password" class="form-control" id="pass" name="pass"
                  		placeholder="비밀번호" value="${userVo.pass }">
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">비밀번호확인</label>
                  <div class="col-sm-10">
                  	<input type="password" class="form-control" id="passChk" name="passChk"
                  		placeholder="비밀번호확인">
                  		<label id="chkOk">비밀번호가 일치하지않습니다</label>
                  </div>
               </div>

               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">이름</label>
                  <div class="col-sm-10">
                 	 <input type="text" class="form-control" id="name" name="name"
                  		placeholder="이름" value="${userVo.name }">
                  </div>
               </div>

               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">주소</label>
                  <div class="col-sm-10">
                 	 <input type="text" class="form-control" id="addr1" name="addr1"
                  		placeholder="주소" value="${userVo.addr1 }">
					<button type="button" id="addrSearchBtn" class="btn btn-default">주소검색</button> 
                  </div>
               </div>
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">상세주소를 입력해주세요</label>
                  <div class="col-sm-10">
                 	 <input type="text" class="form-control" id="addr2" name="addr2"
                  		placeholder="상세주소" value="${userVo.addr2 }">
                  </div>
               </div>
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">우편번호</label>
                  <div class="col-sm-10">
                  	<input type="text" class="form-control" id="zipcd" name="zipcd"
                  		placeholder="우편번호" value="${userVo.zipcd }">
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">생년월일</label>
                  <div class="col-sm-10">
                  	<input type="text" class="form-control" id="birth" name="birth"
                  		placeholder="생년월일" value="<fmt:formatDate value="${userVo.birth}" pattern="yyyy-MM-dd" />">
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">이메일</label>
                  <div class="col-sm-10">
                  	<input type="text" class="form-control" id="email" name="email"
                  		placeholder="이메일" value='${userVo.email}'>
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">연락처</label>
                  <div class="col-sm-10">
                  	<input type="text" class="form-control" id="tel" name="tel"
                  		placeholder="전화번호" value='${userVo.tel}'>
                  </div>
               </div>
               
                <div class="form-group"> 
                   <div class="col-sm-offset-2 col-sm-10"> 
                      <input type="submit" value="정보수정" class="btn btn-default" /> 
                   </div> 
                </div> 
                 
            </form>
			</div>
		</div>
	</div>

</body>
</html>
