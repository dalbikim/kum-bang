<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<title>금방-로그인</title>
<link rel="stylesheet" href="../assets/css/main.css" />
<link href="../assets/css/login.css" rel="stylesheet" />

</head>

<body>
	<div class="login-form">
		<h1>금방</h1>
		<form action="login.me" method="POST">
			<input type="text" name="memberID" placeholder="ID"> <input
				type="password" name="memberPW" placeholder="Password">
			<button type="submit" id="loginBtn">로그인</button>
			<p>
				<a href="findId.html" class="findId">아이디 찾기</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
					href="findPw.html" class="findPw">비밀번호 찾기</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
					href="signup.html" class="signup">회원가입</a>
			</p>
		</form>
	</div>
	
	<!-- Sidebar -->
	<div id="sidebar">
		<%@ include file="../sidebar.jsp"%>
	</div>
	<!-- Scripts -->
	<script src="../assets/js/jquery.min.js"></script>
	<script src="../assets/js/browser.min.js"></script>
	<script src="../assets/js/breakpoints.min.js"></script>
	<script src="../assets/js/util.js"></script>
	<script src="../assets/js/main.js"></script>
</body>
</html>