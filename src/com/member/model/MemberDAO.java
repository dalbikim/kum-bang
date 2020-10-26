package com.member.model;

import java.util.ArrayList;

public interface MemberDAO
{
	// CRUD
	
	// member 등록
	// MemberVO형의 vo(Value Object: DTO랑 동일한 개념인데 read only 속성 가짐)객체 추가
	public void createMember(MemberDTO vo);
	
	// member 전체 조회
	public ArrayList<MemberDTO> readMember();
	
	// member 상세 조회
	public MemberDTO readMember(String memberID);
	
	// member 수정
	public int updateMember(MemberDTO vo);
	
	// member 삭제
	public void deleteMember(String memberID);
	
	// ID 중복 체크
	public String idCheck(String memberID);
	
	// 로그인 체크(리턴값: flag)
	public String loginCheck(String memberID, String memberPW);
	
	// 전체 회원 수
	public int countMember();
}
