package com.member.action;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.member.model.MemberDTO;
import com.member.model.MemberDAOImpl;

@WebServlet("/member/read.me")
public class ReadMember extends HttpServlet // 멤버 전체 조회
{
	private static final long serialVersionUID = 1L;
	
	public ReadMember()
	{
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		ArrayList<MemberDTO> arr = dao.readMember();
		request.setAttribute("members", arr);
		
		RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
