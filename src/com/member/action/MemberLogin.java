package com.member.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.MemberDAOImpl;

@WebServlet("/member/login.me")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String memberID = request.getParameter("memberID");
		String memberPW = request.getParameter("memberPW");
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		String memberName = dao.loginCheck(memberID, memberPW);
		System.out.println("이름 : " + memberName);

		// 로그인 여부
		String message = new String();
		String page = new String();

		if (memberName != null) {
			message = memberName + "님 환영합니다.";
			page = "/member/login_success.jsp";

			// session 객체 인스턴스
			HttpSession session = request.getSession();
			session.setAttribute("memberID", memberID);
			session.setAttribute("message", message);
		} else {
			message = "아이디 또는 비밀번호가 일치하지 않습니다.";

			// 로그인 페이지로 돌아감
			page = "/member/login.jsp?message=" + URLEncoder.encode(message, "utf-8");
		}

		response.sendRedirect(request.getContextPath() + page);

	}
}
