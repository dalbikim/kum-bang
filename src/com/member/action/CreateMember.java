package com.member.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.member.model.MemberDTO;
import com.member.model.MemberDAOImpl;

@WebServlet("/member/create.me")
public class CreateMember extends HttpServlet
{
	private static final long serialVersionUID = 1L; // 직렬화에 사용하는 고유 ID

	public CreateMember() { super(); }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher rd = request.getRequestDispatcher("join.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		MemberDTO member = new MemberDTO();
		member.setMemberID(request.getParameter("memberID"));
		member.setMemberPW(request.getParameter("memberPW"));
		member.setMemberName(request.getParameter("memberName"));
		member.setPhoneNum(request.getParameter("phoneNum"));
		member.setEmailAddress(request.getParameter("emailAddress"));
		member.setMemberAddress(request.getParameter("memberAddress"));
		member.setBirthday(request.getParameter("birthday"));
		member.setSex(request.getParameter("sex"));
		member.setMemberAuthority(request.getParameter("memberAuthority"));

		dao.createMember(member);
		response.sendRedirect("login.me");
	}
}
