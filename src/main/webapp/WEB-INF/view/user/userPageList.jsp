<%@page import="kr.or.ddit.user.util.model.PageVo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style type="text/css">
	.userClick{
		cursor: pointer;
	}
	.userClick:hover {
		background: skyblue !important;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		console.log("document.ready");
		
		
		$("#userList").on("click",".userClick", function(){
			console.log("userClick");
			var userId = $(this).children()[1].innerHTML;
			userId.trim();
			
			$("#userId").val(userId);
			$("#frm").submit();
		});
		//getUserList(1);
		getUserListHtml(1);
		pageListHtml(1);
		
	});
	
	function getUserListHtml(page){
		var pageSize = 10;
		
		$.ajax({
			url : "/user/userPageListAjaxHtml",
			type : "GET",
			data : "page="+page+"&pageSize="+pageSize,
			success : function(dt){
				$("#userList").html(dt);
			}
			
		})
	}
	
	function pageListHtml(page){
		var pageSize = 10;
		
		$.ajax({
			url : "/user/pageListHtml",
			type : "GET",
			data : "page="+page+"&pageSize="+pageSize,
			success : function(dt){
				console.log(dt);
				$(".pagination").html(dt);
			}
			
		})
	}
	
	//page, pageSize 인자를 받아서 해당 페이지에 속하는 사용자 리스트 정보를 가져온다
	function getUserList(page){
		var pageSize =10;
		console.log("page : " + page);
		
		//ajax call
		// 사용자 리스트 데이터만 가져온다
		//html(as-is) --> json(to-be) 데이터를 받는 형태로 변경
		$.ajax({
			type : "GET",
			url : "/user/userPageListAjax",
			data : "page="+page+"&pageSize="+pageSize,
			success : function(data){
				//data (사용자 json 데이터) 를 바탕으로 사용자 리스트를 갱신
				//사용자 리스트 갱신
				//1. 기존 리스트를 삭제
				//2. data 를 이용해 table 태그 작성
				//3. 기존 리스트 위치에다가 붙여넣기
				var html = "";
				$("#userList").html("");
				$.each(data.userList, function(idx,user){
				
					html +=	"<tr class=\"userClick\">"
						+	"<td>"+user.rnum	+"</td>"
						+	"<td>"+user.userId	+"</td>"
						+	"<td>"+user.name	+"</td>"
						+	"<td>"+user.formattedBirth+"</td>"		
						+	"</tr>"
						
				})
				$("#userList").html(html);
				
				
				//$(".userClick").on("click", function(){
				//	console.log("userClick");
				//	var userId = $(this).children()[1].innerHTML;
				//	userId.trim();
				//	
				//	$("#userId").val(userId);
				//	$("#frm").submit();
				//});
				
				var pageHtml = "";
				var pageNum = (data.totalCnt)/10;
				var max = Math.ceil(pageNum);
				pageHtml += "<li><a href='javascript:getUserList("+1+")'>start</a></li>";
				for(var i = 0;i<pageNum;i++){
					if((data.page)==(i+1)){
					pageHtml += "<li><a href='javascript:getUserList("+(i+1)+")' style=\"background:#428bca; color:white;\">"+(i+1)+"</a></li>";	
					} else {
					pageHtml += "<li><a href='javascript:getUserList("+(i+1)+")'>"+(i+1)+"</a></li>";
					}
				}
				pageHtml += "<li><a href='javascript:getUserList("+max+")'>end</a></li>";
				
				$(".pagination").html(pageHtml);
				
						
				
				
				
				
			}
			
		});
		
	}
</script>


<form action="/user/userDetail" method="get" id="frm">
	<input type="hidden" id="userId" name = "userId"/>
</form>

				<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
							<th>번호		</th>
							<th>아이디		</th>
							<th>이름		</th>
							<th>생일		</th>
					</tr>
				</thead>
				
				<tbody id="userList">
				<%--
					<c:forEach items="${userList }" var="ul" varStatus="status">
						<tr class="userClick">
							<td>${status.index+1}</td>
							<td>${ul.userId}</td>
							<td>${ul.name }</td>
							<td><fmt:formatDate value="${ul.birth}" pattern="yyyy-MM-dd" /></td>
						</tr>	
					</c:forEach>
				 --%>
				</tbody>	
			</table>
		</div>

		<a class="btn btn-default pull-right" href="/user/userForm">사용자 등록</a>
		
		<%--
		<%
		int totalCnt = (Integer)request.getAttribute("totalCnt");
		PageVo pageVo = (PageVo)request.getAttribute("pageVo");
		
		int startIndex = pageVo.getPage();
		if(startIndex<6){
			startIndex = 1;
		} else if(startIndex%5==0) {
			startIndex -= 4;
		} else {
			startIndex = startIndex-(startIndex%5)+1;
		}
		int endIndex = startIndex +5;
		int moveFoward = startIndex-5;
		if(moveFoward<0){
			moveFoward = 1;
		}
		if(endIndex > totalCnt/pageVo.getPageSize()+1){
			endIndex = totalCnt/pageVo.getPageSize()+2;
		}
		
		%>
		 --%>

		<div class="text-center">
			<ul class="pagination">
			<%--
			<li><a href="javascript:getUserList(<%=moveFoward%>)"><</a></li>
 			<li><a href="/user/userPageList?pageNum=<%=moveFoward%>"><</a></li> 
			<%
			for(int pg = startIndex;pg < endIndex;pg++){
				if(pg==pageVo.getPage()){
					%><li><a href="javascript:getUserList(<%=pg%>)" style="background:#428bca; color:white;"><%=pg%></a></li><%
							
				} else{
				%>
				<li><a href="javascript:getUserList(<%=pg%>)"><%=pg%></a></li>
				<%
				}
			}
			%>
			
			
			<li><a href="javascript:getUserList(<%=endIndex%>)">></a></li>
			--%>
			</ul>
		</div>
	</div>
</div>
				


