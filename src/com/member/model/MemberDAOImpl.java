package com.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAOImpl implements MemberDAO
{
	private static MemberDAOImpl instance = new MemberDAOImpl();
	public static MemberDAOImpl getInstance()
	{
		return instance;
	}
	
	private Connection getConn() throws Exception
	{
		// Obtain our environment naming context
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		
		// DataSource 를 검색
		// "jdbc/mysql"은 web.xml과 context.xml에 설정되어 있는 name값
		DataSource ds = (DataSource)envCtx.lookup("jdbc/member");
		return ds.getConnection();
	}
	
	// 회원가입
	public void createMember(MemberDTO vo)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = getConn();
			String sql = "INSERT INTO member VALUES(?,?,?,?,?,?,?,?,?)";
			
			pstmt.setString(1, vo.getMemberID());
			pstmt.setString(2, vo.getMemberPW());
			pstmt.setString(3, vo.getMemberName());
			pstmt.setString(4, vo.getPhoneNum());
			pstmt.setString(5, vo.getEmailAddress());
			pstmt.setString(6, vo.getMemberAddress());
			pstmt.setString(7, vo.getSex());
			pstmt.setString(8, vo.getBirthday());
			pstmt.setString(9, vo.getMemberStatus());
			pstmt.setString(10, vo.getMemberAuthority());
			
			pstmt.executeUpdate();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			closeConn(conn, pstmt);
		}
	}
	
	@Override
	public ArrayList<MemberDTO> readMember() // member 전체 조회
	{
		return null;
	}
	
	@Override
	public MemberDTO readMember(String memberID) // member 상세 조회
	{
		return null;
	}
	
	@Override
	public int updateMember(MemberDTO vo) // member 수정
	{
		return 0;
	}
	
	@Override
	public void deleteMember(String memberID) // member 삭제
	{
		
	}
	
	@Override
	public String idCheck(String memberID) // ID 중복 체크
	{
		return null;
	}
	
	// 로그인 체크(비회원: -1, 회원: 0, 관리자: 1, PW 오류: 2)
	public int loginCheck(String memberID, String memberPW)
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		int flag = -1;
		
		try
		{
			conn = getConn();
			String sql = "SELECT memberPW, memberAuthority FROM member WHERE memberID='"+memberID+"'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) // ID 일치
			{
				if(rs.getString("memberPW").equals(memberPW)) // PW 일치
				{
					flag = rs.getInt("memberAuthority");
				}	
				
				else // PW 오류
				{
					flag = 2;
				}
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			closeConn(conn, stmt, rs);
		}
		
		return flag;
	}
	
	@Override
	public int countMember() // 전체 회원 수
	{
		return 0;
	}
	
	private void closeConn(Connection conn, PreparedStatement pstmt)
	{
		try
		{
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	private void closeConn(Connection conn, Statement stmt, ResultSet rs)
	{
		try
		{
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
			if(rs != null) rs.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
