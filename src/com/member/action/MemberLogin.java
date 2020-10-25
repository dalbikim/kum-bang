package com.member.action;

import java.io.IOException;
import java.io.PrintWriter;

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

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
      rd.forward(request, response);   
   }
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      String memberID = request.getParameter("memberID");
      String memberPW = request.getParameter("memberPW");
      MemberDAOImpl dao = MemberDAOImpl.getInstance();
      int flag = dao.loginCheck(memberID, memberPW);
      if(flag==0 || flag==1) {
         HttpSession session = request.getSession();
         session.setAttribute("memberID", memberID);
      }
      
      response.setContentType("text/html; charset=utf-8");
      PrintWriter out = response.getWriter();
      out.println(flag);
   }
}
