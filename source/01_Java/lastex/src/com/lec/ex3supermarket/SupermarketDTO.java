package com.lec.ex3supermarket;

public class SupermarketDTO {
	private String cid;
	private String ctel;
	private String cname;
	private int cpoint;
	private int sumpurchase;
	private String mlevel;
	private int plus;
	public SupermarketDTO() {	}
	public SupermarketDTO(String ctel, String cname) {
		this.ctel = ctel;
		this.cname = cname;
	}
	public SupermarketDTO(String cid, String ctel, String cname, int cpoint, int sumpurchase, String mlevel, int plus) {
		super();
		this.cid = cid;
		this.ctel = ctel;
		this.cname = cname;
		this.cpoint = cpoint;
		this.sumpurchase = sumpurchase;
		this.mlevel = mlevel;
		this.plus = plus;
	}
	@Override
	public String toString() {
		return cid + "\t" + ctel + "\t" + cname + "\t" + cpoint
				+ "\t" + sumpurchase + "\t" + mlevel + "\t" + plus;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
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
	public int getSumpurchase() {
		return sumpurchase;
	}
	public void setSumpurchase(int sumpurchase) {
		this.sumpurchase = sumpurchase;
	}
	public String getMlevel() {
		return mlevel;
	}
	public void setMlevel(String mlevel) {
		this.mlevel = mlevel;
	}
	public int getPlus() {
		return plus;
	}
	public void setPlus(int plus) {
		this.plus = plus;
	}
	
}
