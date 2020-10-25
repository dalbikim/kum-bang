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

@WebServlet("/member/view.me")
public class ReadOneMember extends HttpServlet
{
private static final long serialVersionUID = 1L;
	
	public ReadOneMember()
	{
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		String memberID = (String)session.getAttribute("MemberID");
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		MemberDTO dto = dao.readMember(memberID);
		request.setAttribute("member", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}
}
