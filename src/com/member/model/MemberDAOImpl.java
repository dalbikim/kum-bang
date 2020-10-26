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

import board.DBConnect;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAOImpl instance = new MemberDAOImpl();

	public static MemberDAOImpl getInstance() {
		return instance;
	}

	DBConnect dbconn = null;

	public MemberDAOImpl() {
		dbconn = new DBConnect();
	}

//	private Connection getConn() throws Exception
//	{
//		// Obtain our environment naming context
//		Context initCtx = new InitialContext();
//		Context envCtx = (Context)initCtx.lookup("java:comp/env");
//		
//		// DataSource 를 검색
//		// "jdbc/kum-bang/member"은 web.xml과 context.xml에 설정되어 있는 name값
//		DataSource ds = (DataSource)envCtx.lookup("jdbc/kum-bang/member");
//		return ds.getConnection();
//	}

	// 회원가입
	public void createMember(MemberDTO vo) {
		Connection conn = dbconn.getConnection();
		PreparedStatement pstmt = null;

		try {
			String sql = "INSERT INTO member (memberID, memberPW, memberName, phoneNum, emailAddress, memberAddress, birthday, sex, memberAuthority) VALUES(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getMemberID());
			pstmt.setString(2, vo.getMemberPW());
			pstmt.setString(3, vo.getMemberName());
			pstmt.setString(4, vo.getPhoneNum());
			pstmt.setString(5, vo.getEmailAddress());
			pstmt.setString(6, vo.getMemberAddress());
			pstmt.setString(7, vo.getBirthday());
			pstmt.setString(8, vo.getSex());
			pstmt.setString(9, vo.getMemberAuthority());

			pstmt.executeUpdate();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			closeConn(conn, pstmt);
		}
	}

	public ArrayList<MemberDTO> readMember() // member 전체 조회
	{
		Connection conn = dbconn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> arr = new ArrayList<MemberDTO>();

		try {
			String sql = "select * from member";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setMemberID(rs.getString("memberID"));
				dto.setMemberName(rs.getString("memberName"));
				dto.setPhoneNum(rs.getString("phoneNum"));
				dto.setEmailAddress(rs.getString("emailAddress"));
				dto.setMemberAddress(rs.getString("memberAddress"));
				dto.setSex(rs.getString("sex"));
				dto.setBirthday(rs.getString("birthday"));
				dto.setMemberStatus(rs.getString("memberStatus"));
				dto.setMemberAuthority(rs.getString("memberAuthority"));
				arr.add(dto);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			closeConn(conn, stmt, rs);
		}

		return arr;
	}

	public MemberDTO readMember(String memberID) // member 상세 조회
	{
		Connection conn = dbconn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		MemberDTO dto = null;

		try {
			String sql = "select * from member where memberID='" + memberID + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				dto = new MemberDTO();
				dto.setMemberID(rs.getString("memberID"));
				dto.setMemberName(rs.getString("memberName"));
				dto.setPhoneNum(rs.getString("phoneNum"));
				dto.setEmailAddress(rs.getString("emailAddress"));
				dto.setMemberAddress(rs.getString("memberAddress"));
				dto.setSex(rs.getString("sex"));
				dto.setBirthday(rs.getString("birthday"));
				dto.setMemberStatus(rs.getString("memberStatus"));
				dto.setMemberAuthority(rs.getString("memberAuthority"));
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			closeConn(conn, stmt, rs);
		}

		return dto;
	}

	public int updateMember(MemberDTO vo) // member 수정
	{
		Connection conn = dbconn.getConnection();
		PreparedStatement pstmt = null;

		int flag = 0;

		try {
			String sql = "update member set memberPW=?, memberName=?, phoneNum=?, emailAddress=?, memberAddress=? where memberID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemberPW());
			pstmt.setString(2, vo.getMemberName());
			pstmt.setString(3, vo.getPhoneNum());
			pstmt.setString(4, vo.getEmailAddress());
			pstmt.setString(5, vo.getMemberAddress());
			pstmt.setString(6, vo.getMemberID());

			flag = pstmt.executeUpdate();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			closeConn(conn, pstmt);
		}

		return flag;
	}

	@Override
	public void deleteMember(String memberID) // member 삭제
	{
		Connection conn = dbconn.getConnection();
		Statement stmt = null;

		try {
			String sql = "delete from member where memberID='" + memberID + "'";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			closeConn(conn, stmt, null);
		}
	}

	public String idCheck(String memberID) // ID 중복 체크
	{
		Connection conn = dbconn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String flag = "yes"; // 사용 가능

		try {
			String sql = "select * from member where memberID='" + memberID + "'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				flag = "no"; // 사용 불가능
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			closeConn(conn, stmt, rs);
		}

		return flag;
	}

	// 로그인 체크(비회원: -1, 회원: 0, 관리자: 1, PW 오류: 2)
	public String loginCheck(String memberID, String memberPW) {
		String memberName = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dbconn.getConnection();
			String SQL = "SELECT memberName FROM member WHERE memberID=? and memberPW=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, memberID);
			pstmt.setString(2, memberPW);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberName = rs.getString("memberName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return memberName;
	}

	@Override
	public int countMember() // 전체 회원 수
	{
		Connection conn = dbconn.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		int count = 0;

		try {
			String sql = "SELECT count(*) FROM member";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				count = rs.getInt(1);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			closeConn(conn, stmt, rs);
		}

		return count;
	}

	private void closeConn(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void closeConn(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}