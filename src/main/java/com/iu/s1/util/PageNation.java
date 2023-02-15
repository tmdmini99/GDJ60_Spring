package com.iu.s1.util;

public class PageNation {
	
	private Long startRow;
	private Long lastRow;
	private Long startNum;
	private Long lastNum;
	private Long page;
	private Long perpage;
	
	private boolean after;
	private boolean before;
	
	
	
	public void makeRow() {
		
		this.startRow=(this.getPage()-1)*this.getPerpage()+1;
		this.lastRow=this.getPage()*this.getPerpage();
	}
	public void makeNum(Long totalRow) {
		
		//1.전체 row의 갯수를 구하기
		//2.총 page의 갯수
		Long totalPage = totalRow/this.getPerpage();
		if(totalRow%this.getPerpage() != 0) {
			totalPage++;
		}
		
		//3.한 블럭(페이지 수)에 출력할 번호의 갯수
		
		Long perBlock=10L;
		//4. 총 블럭의 수
		Long totalBlock=totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}
		//5. page 번호로 현재 블럭 번호 구하기
		// page1-5번이면 curBlock은 1이 되어야함
		// page 6-10 curBlock 2
		Long curBlock=this.getPage()/perBlock;
		if(this.getPage()%perBlock != 0) {
			curBlock++;
		}
		//6.curBlock의 시작번호와 끝 번호를 계산
		/* curBlock	startNum	lastNum
		 * 1		1			5
		 * 2		6			10
		 * 3		11			15
		 * 
		 * 
		 * */
		this.startNum=(curBlock-1)*perBlock+1;
		
		this.lastNum=curBlock*perBlock;
		
		this.after=true;
		if(this.lastNum>totalPage) {
			this.lastNum=totalPage;
			this.after=false;
		}
		this.before=false;
		if(this.startNum == 0) {
			this.before=true;
		}
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	public boolean isAfter() {
		return after;
	}
	public void setAfter(boolean after) {
		this.after = after;
	}
	public boolean isBefore() {
		return before;
	}
	public void setBefore(boolean before) {
		this.before = before;
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
