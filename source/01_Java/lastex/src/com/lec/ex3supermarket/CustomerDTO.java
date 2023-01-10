package com.lec.ex3supermarket;

public class CustomerDTO {
	private int cid;
	private String ctel;
	private String cname;
	private int cpoint;
	private int camount;
	private String levelname;
	private int levelno;
	private int forlevelup;
	public CustomerDTO() {	}
	public CustomerDTO(String cname, String ctel) {
		this.cname = cname;
		this.ctel = ctel;
	}
	public CustomerDTO(int cid, String ctel, String cname, String levelname, int cpoint, int camount, int forlevelup) {
		super();
		this.cid = cid;
		this.ctel = ctel;
		this.cname = cname;
		this.levelname = levelname;
		this.cpoint = cpoint;
		this.camount = camount;
		this.forlevelup = forlevelup;
	}
	
	@Override
	public String toString() {
		return cid + "\t" + ctel + "\t" + cname + "\t" + cpoint
				+ "\t" + camount + "\t" + levelname + "\t" + levelno;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCtel() {
		return ctel;
	}
	public void setCtel(String ctel) {
		this.ctel = ctel;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCpoint() {
		return cpoint;
	}
	public void setCpoint(int cpoint) {
		this.cpoint = cpoint;
	}
	public int getCamount() {
		return camount;
	}
	public void setCamount(int camount) {
		this.camount = camount;
	}
	public String getLevelname() {
		return levelname;
	}
	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}
	public int getLevelno() {
		return levelno;
	}
	public void setLevelno(int levelno) {
		this.levelno = levelno;
	}
	public int getForlevelup() {
		return forlevelup;
	}
	public void setForlevelup(int forlevelup) {
		this.forlevelup = forlevelup;
	}
	
}
