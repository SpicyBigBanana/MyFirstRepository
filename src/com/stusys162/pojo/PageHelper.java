package com.stusys162.pojo;

public class PageHelper {
	private int startindex;
	private int pagesize;

	public PageHelper() {
		super();
	}

	public PageHelper(int startindex, int pagesize) {
		super();
		this.startindex = startindex;
		this.pagesize = pagesize;
	}

	public int getStartindex() {
		return startindex;
	}

	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
}
