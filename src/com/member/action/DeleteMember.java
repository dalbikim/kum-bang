package com.member.action;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.member.model.MemberDTO;
import com.member.model.MemberDAOImpl;

@WebServlet("/member/delete.me")
public class DeleteMember extends HttpServlet // 탈퇴
{
	private static final long serialVersionUID = 1L;
	
	public DeleteMember()
	{
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		String memberID = (String)session.getAttribute("MemberID");
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		dao.deleteMember(memberID);
		session.invalidate();
		response.sendRedirect("login.me");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}
}
