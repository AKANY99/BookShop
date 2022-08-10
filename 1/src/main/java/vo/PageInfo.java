package vo;

// 페이징 처리 관련 정보를 저장하는 클래스 (= DTO 역할)
public class PageInfo {
	private int pageNum;
	private int maxPage;
	private int startPage;
	private int endPage;
	private int listCount;
	
	public PageInfo(int pageNum, int maxPage, int startPage, int endPage, int listCount) {
		super();
		this.pageNum = pageNum;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.listCount = listCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	

}
