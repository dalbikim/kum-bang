<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="board.model.*"%>

<jsp:useBean id="dao" class="board.model.BoardDAO" />

<%
	int idx = Integer.parseInt(request.getParameter("idx"));
int pg = Integer.parseInt(request.getParameter("pg"));
BoardDTO vo = dao.getView(idx);
dao.UpdateHit(idx);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게시판</title>
<link rel="stylesheet" href="../assets/css/main.css" />
</head>
<body>
	<table>
		<tr>
			<td>
				<table>
						<td align="center">내 용</td>
	
				</table>
				<table>
					<tr>
						<td>&nbsp;</td>
						<td align="center">글번호</td>
						<td ><%=idx%></td>
						<td>&nbsp;</td>
					</tr>
						<td colspan="4"></td>
					<tr>
						<td>&nbsp;</td>
						<td align="center">조회수</td>
						<td><%=vo.getHit()%></td>
						<td>&nbsp;</td>
					</tr>
						<td colspan="4"></td>
					<tr>
						<td>&nbsp;</td>
						<td align="center">이름</td>
						<td><%=vo.getName()%></td>
						<td>&nbsp;</td>
					</tr>
						<td colspan="4"></td>
					
					<tr>
						<td>&nbsp;</td>
						<td align="center">작성일</td>
						<td><%=vo.getTime()%></td>
						<td>&nbsp;</td>
					</tr>
						<td colspan="4"></td>
					
					<tr>
						<td>&nbsp;</td>
						<td align="center">제목</td>
						<td><%=vo.getTitle()%></td>
						<td>&nbsp;</td>
					</tr>
						<td colspan="4"></td>
					
					<tr>
						<td width="0"></td>
						<td colspan="4" height="200"><%=vo.getMemo()%>
					</tr>
					<tr align="center">
						<td>&nbsp;</td>
						<td colspan="2"><input type=button value="글쓰기"
							OnClick="window.location='write.jsp'"> <input type=button
							value="답글"
							OnClick="window.location='reply.jsp?idx=<%=idx%>&pg=<%=pg%>'">
							<input type=button value="목록"
							OnClick="window.location='list.jsp?pg=<%=pg%>'"> <input
							type=button value="수정"
							OnClick="window.location='modify.jsp?idx=<%=idx%>&pg=<%=pg%>'">
							<input type=button value="삭제"
							OnClick="window.location='delete.jsp?idx=<%=idx%>&pg=<%=pg%>'">
						<td>&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
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
