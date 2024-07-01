package com.sist.dao;
/*
 FNO                                       NOT NULL NUMBER
 NAME                                      NOT NULL VARCHAR2(200)
 TYPE                                      NOT NULL VARCHAR2(200)
 PHONE                                              VARCHAR2(30)
 ADDRESS                                            VARCHAR2(700)
 SCORE                                              NUMBER(2,1)
 THEME                                              CLOB
 POSTER                                    NOT NULL VARCHAR2(260)
 CONTENT                                            CLOB
 HIT                                                NUMBER
 JJIMCOUNT                                          NUMBER
 LIKECOUNT                                          NUMBER
 */
public class FoodVO {
	private int fno,hit,jjimcount,likecount;
	private double score;
	private String name,type,phone,address,theme,poster,content;
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getJjimcount() {
		return jjimcount;
	}
	public void setJjimcount(int jjimcount) {
		this.jjimcount = jjimcount;
	}
	public int getLikecount() {
		return likecount;
	}
	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
