<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../assets/css/main.css" />
<link href="../assets/css/join.css" rel="stylesheet" />
</head>

<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<%@ include file="../header.jsp"%>
				</header>

				<div class="signup-form">
					<h1>회원가입</h1>
					<form action="create.me" method="post" id="frm">
						<div class="form-group">
							<label for="memberID">아이디</label><br> <input
								style="width: 65%;" type="text" class="form-control"
								id="memberID" placeholder="아이디를 입력하시오" name="memberID">
							<button type="button" id="idcheck" class="btn btn-primary">중복확인</button>
						</div>

						<div class="form-group">
							<label for="memberPW">비밀번호</label> <input type="password"
								class="form-control" id="memberPW" placeholder="비밀번호를 입력하시오"
								name="memberPW">
						</div>

						<div class="form-group">
							<label for="memberName">이름</label> <input type="text"
								class="form-control" id="memberName" placeholder="이름을 입력하시오"
								name="memberName">
						</div>

						<div class="form-group">
							<label for="phoneNum">전화번호</label> <input type="text"
								class="form-control" id="phoneNum" placeholder="ex) 01012345678"
								name="phoneNum">
						</div>

						<div class="form-group">
							<label for="email">이메일 주소</label> <input type="text"
								class="form-control" id="emailAddress"
								placeholder="ex) abc123@kumoh.ac.kr" name="emailAddress">
						</div>

						<div class="form-group">
							<label for="address">주소</label> <input type="text"
								class="form-control" id="memberAddress" placeholder="주소를 입력하시오"
								name="memberAddress">
						</div>

						<div class="form-group">
							<label for="address">생년월일</label> <input type="text"
								class="form-control" id="birthday" placeholder="ex) 990101"
								name="birthday">
						</div>

						<label for="sex">성별</label><br>
						<div class="form-check-inline"
							style="width: 100%; padding: 15px; border: 1px solid #dddddd; margin-bottom: 15px; box-sizing: border-box; height: 47px;">
							&nbsp;<label for="male" class="form-check-label">남</label><input
								type="radio" class="form-check-input" id="male" name="sex"
								value="male">&nbsp; &nbsp; &nbsp; &nbsp; <label
								for="female" class="form-check-label">여</label><input
								type="radio" class="form-check-input" id="female" name="sex"
								value="female">
						</div>

						<label for="memberAuthority">회원 구분</label>
						<div class="form-check-inline"
							style="width: 100%; padding: 15px; border: 1px solid #dddddd; margin-bottom: 15px; box-sizing: border-box; height: 47px;">
							&nbsp;<label for="student" class="form-check-label">학생</label><input
								type="radio" class="form-check-input" id="student"
								name="memberAuthority" value="student"> &nbsp;&nbsp;<label
								for="broker" class="form-check-label">중개사</label><input
								type="radio" class="form-check-input" id="broker"
								name="memberAuthority" value="broker"> &nbsp;&nbsp;<label
								for="owner" class="form-check-label">집주인</label><input
								type="radio" class="form-check-input" id="owner"
								name="memberAuthority" value="owner">
						</div>

						<button type="submit" id="send" class="btn btn-primary">회원가입</button>
					</form>
				</div>
			</div>
		</div>
			<!-- Sidebar -->
	<div id="sidebar">
		<%@ include file="../sidebar.jsp"%>
	</div>
	</div>

	<!-- Scripts -->
	<script src="../assets/js/jquery.min.js"></script>
	<script src="../assets/js/browser.min.js"></script>
	<script src="../assets/js/breakpoints.min.js"></script>
	<script src="../assets/js/util.js"></script>
	<script src="../assets/js/main.js"></script>
</body>
</html>
