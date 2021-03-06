package com.member.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.member.model.MemberDTO;
import com.member.model.MemberDAOImpl;

@WebServlet("/member/update.me")
public class UpdateMember extends HttpServlet
{
	private static final long serialVersionUID = 1L; // 직렬화에 사용하는 고유 ID

	public UpdateMember() { super(); }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		MemberDTO member = new MemberDTO();
		member.setMemberID(request.getParameter("userId"));
		member.setMemberPW(request.getParameter("userPw"));
		member.setMemberName(request.getParameter("userName"));
		member.setPhoneNum(request.getParameter("userPhoneNum"));
		member.setEmailAddress(request.getParameter("userEmail"));
		member.setMemberAddress(request.getParameter("address"));
		member.setSex(request.getParameter("sex"));
		member.setBirthday(request.getParameter("birthday"));
		
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		int flag = dao.updateMember(member);
		HttpSession session = request.getSession();
		if (flag==1)
		{
			session.invalidate();
			response.sendRedirect("login.me");
		}
	}
}
