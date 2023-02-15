package com.iu.s1.util;

public class PageNation {
	
	private Long startRow;
	private Long lastRow;
	private Long startNum;
	private Long lastNum;
	private Long page;
	private Long perpage;
	
	
	
	public void makeRow() {
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public Long getPage() {
		if(this.page == null || this.page == 0) {
			this.setPage(1L);
		}
		
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getPerpage() {
		if(this.perpage == null || this.perpage == 0) {
			this.setPerpage(10L);
		}
		return perpage;
	}
	public void setPerpage(Long perpage) {
		this.perpage = perpage;
	}
	
	
}
