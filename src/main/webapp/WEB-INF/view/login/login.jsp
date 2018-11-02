<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="utf-8">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>로그인</title>

 <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap_login.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/signin.css" rel="stylesheet">

    

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
 <script type="text/javascript">
 	function getCookie(cookieName) {
 		var cookieStr = document.cookie
 		var cookieList = cookieStr.split("; ");
		var resultStr = null;
		
		for(var i = 0; i < cookieList.length; i++){
			if(cookieList[i].startsWith(cookieName + "=")){
				resultStr = cookieList[i].substring((cookieName + "=").length);
				break;
			}
		}
		
		return resultStr;
	}
 	
 	$('document').ready(function() {
 		console.log("test");
		 	var userId = getCookie("userId");
	 	if(getCookie("remember") == "Y"){
		 	$("#userId").val(userId);
		 	$("#remember-me").attr("checked", true);	//						  checked/unchecked
		 	$("#remember-me").prop("checked", true);	//attr이랑 조금 다름 구글링 해봐 , true/false
	 	} else {
		 	$("#remember-me").attr("checked", false);
	 	}
	});
 	
 </script>

</head>

<!-- 사용자 아이디와 비밀번호를 입력받도록한다 
	login.jsp
	>>
	loginProcess.jsp

-->
<body>
	<!-- 브라우저 주소줄에 입력한 경우 : get
		 form 태그의 method 속성 : get/post
	 -->
	 <%--
	<form action="/loginServlet" method="get">
	 --%>
	<%-- 
	<form action="/login/loginProcess.jsp" method="get">
	--%>
	<%-- 
	--%>
	
	<div class="container">

      <form  action="/user/loginProcess" method="post" class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" name ="userId" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="pass" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input id="remember-me" name="remember-me" type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->
	
	
</body>
</html>