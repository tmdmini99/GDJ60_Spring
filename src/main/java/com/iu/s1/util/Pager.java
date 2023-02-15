package com.iu.s1.util;

public class Pager {
	
	//한페이지에 출력할 Row의 갯수 
	private Long perPage;
	//Client가 보고싶은페이지 번호(parameter로 받아옴)
	private Long page;
	
	//Table에서 조회할 시작번호
	private Long startRow;
	//Table에서 조회할 끝번호
	private Long lastRow;
	
	//전체 row의 갯수를 담을 변수
	//private Long totalCount;
	
	//JSP에 출력하기 위한 시작번호
	private Long startNum;
	//JSP에 출력하기 위한 끝번호
	private Long lastNum;
	
	private boolean before;
	private boolean after;
	
	private Long totalPage;
	
	//startRow,lastRow 계산 하는 메서드
	public void makeRow() {
		this.startRow=(this.getPage()-1)*this.getPerPage()+1;
		this.lastRow=this.getPage()*this.getPerPage();
	}
	
	//startNum lastNum
	public void makeNum(Long totalCount) {
		
		
		
		//1.전체 row의 갯수를 구하기
		//2.총 page의 갯수
		this.totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage()!=0) {
			totalPage++;
		}
		if(this.getPage() >totalPage) {
			this.setPage(totalPage);
		}
		//3.한 블럭(페이지 수)에 출력할 번호의 갯수
		Long perBlock=5L;
		
		//4. 총 블럭의 수
		Long totalBlock=totalPage/perBlock;
		if(totalPage%perBlock !=0) {
			totalBlock++;
		}
		//5. page 번호로 현재 블럭 번호 구하기
		// page1-5번이면 curBlock은 1이 되어야함
		// page 6-10 curBlock 2
		Long curBlock=this.getPage()/perBlock;
		if(this.getPage()%perBlock !=0) {
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
		if(curBlock==totalBlock){
			lastNum=totalPage;
			this.after=false;
		}
		this.before=false;
		if(curBlock==1) {
			this.before=true;
		}
		
		
	}
	
	
	
	
	
	
//	public Long getTotalCount() {
//		return totalCount;
//	}
//
//
//
//	public void setTotalCount(Long totalCount) {
//		this.totalCount = totalCount;
//	}



	
	
	
	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public boolean isBefore() {
		return before;
	}

	public void setBefore(boolean before) {
		this.before = before;
	}

	public boolean isAfter() {
		return after;
	}

	public void setAfter(boolean after) {
		this.after = after;
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

	public Long getPerPage() {
		
		if(this.perPage==null || this.perPage==0) {
			this.perPage=10L;
		}
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPage() {
		if(this.page == null || this.page <=0) {
			this.page=1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
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
	
	
}
