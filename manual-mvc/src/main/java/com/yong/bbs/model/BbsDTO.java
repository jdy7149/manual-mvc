package com.yong.bbs.model;

import java.sql.Date;

public class BbsDTO {
	private int idx;
	private String title;
	private String writer;
	private Date writeDate;
	private String content;
	private int viewNum;
	private int ref;
	private int lev;
	private int sunbun;
	
	public BbsDTO() {
		
	}

	public BbsDTO(int idx, String title, String writer, Date writeDate, String content, int viewNum, int ref, int lev,
			int sunbun) {
		super();
		this.idx = idx;
		this.title = title;
		this.writer = writer;
		this.writeDate = writeDate;
		this.content = content;
		this.viewNum = viewNum;
		this.ref = ref;
		this.lev = lev;
		this.sunbun = sunbun;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String contetnt) {
		this.content = contetnt;
	}

	public int getViewNum() {
		return viewNum;
	}

	public void setViewNum(int viewNum) {
		this.viewNum = viewNum;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	public int getSunbun() {
		return sunbun;
	}

	public void setSunbun(int sunbun) {
		this.sunbun = sunbun;
	}
	
	
}
