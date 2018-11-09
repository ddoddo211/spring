<%@page import="kr.or.ddit.user.util.model.PageVo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


	<%
	UserVo userVo =  (UserVo)request.getAttribute("userVo");
	
	
	%>


			<form class="form-horizontal" role="form" method="get" action="/user/userUpdate">
			
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
                  <div class="col-sm-10">
                  	
                  	<c:choose>
                  		<c:when test="${userVo.profile==null}">
                  			<img src="/profile/noimage.jpg"/>
                  		</c:when>
                  		<c:otherwise>
                  			<img src="${userVo.profile }"/>
                  		</c:otherwise>
                  	</c:choose>
                  </div>
               </div>
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
                  <div class="col-sm-10">
                     <label for="userNm" class=" control-label">${userVo.userId}</label>
                     <input type="hidden" name="userId" value="${userVo.userId}">
                  </div>
               </div>

               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">이름</label>
                  <div class="col-sm-10">
                     <label class=" control-label">${userVo.name}</label>
                  </div>
               </div>

               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">주소</label>
                  <div class="col-sm-10">
                     <label class="control-label">${userVo.addr1}</label>
                  </div>
               </div>
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">상세주소</label>
                  <div class="col-sm-10">
                     <label class=" control-label">${userVo.addr2}</label>
                  </div>
               </div>
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">우편번호</label>
                  <div class="col-sm-10">
                     <label class=" control-label">${userVo.zipcd}</label>
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">생년월일</label>
                  <div class="col-sm-10">
                     <label class=" control-label"><fmt:formatDate value="${userVo.birth}" pattern="yyyy-MM-dd" /></label>
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">이메일</label>
                  <div class="col-sm-10">
                     <label class=" control-label">${userVo.email}</label>
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">연락처</label>
                  <div class="col-sm-10">
                     <label class=" control-label">${userVo.tel}</label>
                  </div>
               </div>
               
               <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                     <button type="submit" class="btn btn-default">정보 수정</button>
                  </div>
               </div>
                
            </form>
