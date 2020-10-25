<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="board.model.BoardDAO"/>
<jsp:useBean id="vo" class="board.model.BoardDTO"/>
<jsp:setProperty name="vo" property="*" />

<%	
	request.setCharacterEncoding("euc-kr");
	int max = dao.getMax();
	dao.insertWrite(vo, max);
%>

  <script language=javascript>
   self.window.alert("입력한 글을 저장하였습니다.");
   location.href="list.jsp";
  </script>