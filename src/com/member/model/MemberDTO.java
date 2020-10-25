package com.member.model;

public class MemberDTO
{
	private String memberID;
	private String memberPW;
	private String memberName;
	private String phoneNum;
	private String emailAddress;
	private String memberAddress;
	private String sex;
	private String birthday;
	private String memberStatus;
	private String memberAuthority;
	
	public String getMemberID() {
		return memberID == null? "" : memberID.trim();
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMemberPW() {
		return memberPW == null? "" : memberPW.trim();
	}
	public void setMemberPW(String memberPW) {
		this.memberPW = memberPW;
	}
	public String getMemberName() {
		return memberName == null? "" : memberName.trim();
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPhoneNum() {
		return phoneNum == null? "" : phoneNum.trim();
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmailAddress() {
		return emailAddress == null? "" : emailAddress.trim();
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getMemberAddress() {
		return memberAddress == null? "" : memberAddress.trim();
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getSex() {
		return sex == null? "" : sex.trim();
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday == null? "" : birthday.trim();
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMemberStatus() {
		return memberStatus == null? "" : memberStatus.trim();
	}
	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}
	public String getMemberAuthority() {
		return memberAuthority == null? "" : memberAuthority.trim();
	}
	public void setMemberAuthority(String memberAuthority) {
		this.memberAuthority = memberAuthority;
	}
	
	
}
