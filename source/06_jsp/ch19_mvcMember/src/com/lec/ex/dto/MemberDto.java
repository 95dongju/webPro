package com.lec.ex.dto;

import java.sql.Date;

public class MemberDto {
	private String mid;
	private String mpw;
	private String mname;
	private String memail;
	private String mphoto;
	private Date mbirth;
	private String maddress;
	public MemberDto() {}
	public MemberDto(String mid, String mpw, String mname, String memail, String mphoto, Date mbirth, String maddress) {
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.memail = memail;
		this.mphoto = mphoto;
		this.mbirth = mbirth;
		this.maddress = maddress;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMphoto() {
		return mphoto;
	}
	public void setMphoto(String mphoto) {
		this.mphoto = mphoto;
	}
	public Date getMbirth() {
		return mbirth;
	}
	public void setMbirth(Date mbirth) {
		this.mbirth = mbirth;
	}
	public String getMaddress() {
		return maddress;
	}
	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}
	@Override
	public String toString() {
		return "MemberDto [mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", memail=" + memail + ", mphoto="
				+ mphoto + ", mbirth=" + mbirth + ", maddress=" + maddress + "]";
	}
}
