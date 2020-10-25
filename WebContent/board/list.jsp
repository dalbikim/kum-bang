<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="board.*"%>
<%@ page import="java.util.*"%>

<jsp:useBean id="dao" class="board.DAO" />

<%
	int total = dao.count();
ArrayList<VO> alist = dao.getMemberList();
int size = alist.size();
int size2 = size;

final int ROWSIZE = 10;
final int BLOCK = 10;
int indent = 0;

int pg = 1;

if (request.getParameter("pg") != null) {
	pg = Integer.parseInt(request.getParameter("pg"));
}

int end = (pg * ROWSIZE);

int allPage = 0;

int startPage = ((pg - 1) / BLOCK * BLOCK) + 1;
int endPage = ((pg - 1) / BLOCK * BLOCK) + BLOCK;

allPage = (int) Math.ceil(total / (double) ROWSIZE);

if (endPage > allPage) {
	endPage = allPage;
}

size2 -= end;
if (size2 < 0) {
	end = size;
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>�Խ���</title>

 <link rel="stylesheet" href="../assets/css/main.css" />
</head>
<body>
				<!-- Header -->
				<header id="header">
					<%@ include file="../header.jsp"%>
				</header>
				
				
	<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr height="5">
			<td width="5"></td>
		</tr>
		<tr
			text-align: center;">
			<td width="5"><img src="../img/table_left.gif" width="5"
				height="30" /></td>
			<td width="73">��ȣ</td>
			<td width="379">����</td>
			<td width="73">�ۼ���</td>
			<td width="164">�ۼ���</td>
			<td width="58">��ȸ��</td>
			<td width="7"><img src="../img/table_right.gif" width="5"
				height="30" /></td>
		</tr>
		<%
			if (total == 0) {
		%>
		<tr align="center" bgcolor="#FFFFFF" height="30">
			<td colspan="6">��ϵ� ���� �����ϴ�.</td>
		</tr>
		<%
			} else {
		for (int i = ROWSIZE * (pg - 1); i < end; i++) {
			VO vo = alist.get(i);
			indent = vo.getIndent();
			int idx = vo.getNum();
		%>
		<tr height="25" align="center">
			<td align="center">&nbsp;</td>
			<td align="center"><%=idx%></td>
			<td align="left">
				<%
					for (int j = 0; j < indent; j++) {
				%> &nbsp;&nbsp;&nbsp;<%
 	}
 if (indent != 0) {
 %><img src='../img/reply_icon.gif' /> <%
 	}
 %> <a href="view.jsp?idx=<%=idx%>&pg=<%=pg%>"><%=vo.getTitle()%></a>
				<%
					if (vo.isDayNew()) {
				%> <img src='../img/new.jpg' /> <%
 	}
 %>
			</td>
			<td align="center"><%=vo.getName()%></td>
			<td align="center"><%=vo.getTime()%></td>
			<td align="center"><%=vo.getHit()%></td>
			<td align="center">&nbsp;</td>
		<tr height="1" bgcolor="#D2D2D2">
			<td colspan="6"></td>
		</tr>
		<%
			}
		}
		%>
		<tr height="1" bgcolor="#82B5DF">
			<td colspan="6" width="752"></td>
		</tr>
	</table>
	<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td colspan="4" height="5"></td>
		</tr>
		<tr>
			<td align="center">
				<%
					if (pg > BLOCK) {
				%> [<a href="list.jsp?pg=1">����</a>] [<a
				href="list.jsp?pg=<%=startPage - 1%>">��</a>] <%
					}
				%> <%
 	for (int i = startPage; i <= endPage; i++) {
 	if (i == pg) {
 %> <u><b>[<%=i%>]
				</b></u> <%
 	} else {
 %> [<a href="list.jsp?pg=<%=i%>"><%=i%></a>] <%
 	}
 }
 %> <%
 	if (endPage < allPage) {
 %> [<a href="list.jsp?pg=<%=endPage + 1%>">��</a>] [<a
				href="list.jsp?pg=<%=allPage%>">����</a>] <%
 	}
 %>
			</td>
		</tr>
		<tr align="center">
			<td><input type=button value="�۾���"
				OnClick="window.location='write.jsp'"></td>
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