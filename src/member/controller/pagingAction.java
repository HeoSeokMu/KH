package member.controller;

public class pagingAction {

	private int currentPage; // 현재페이지
	private int totalCount;	 // 전체 게시물 수
	private int totalPage;	 // 전체 페이지 수
	private int blockCount;	 // 한 페이지의  게시물의 수
	private int blockPage;	 // 한 화면에 보여줄 페이지 수
	private int startCount;	 // 한 페이지에서 보여줄 게시글의 시작 번호
	private int endCount;	 // 한 페이지에서 보여줄 게시글의 끝 번호
	private int startPage;	 // 시작 페이지
	private int endPage;	 // 마지막 페이지
	
	private StringBuffer pagingHtml;

	// 페이징 생성자
	public pagingAction(int currentPage, int totalCount, int blockCount, int blockPage) {
		System.out.println("blockCount : " + blockCount);

		this.blockCount = blockCount;
		this.blockPage = blockPage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;

		// 전체 페이지 수    							  11	/	   10
		// 차트 연산								  17	/	   50	//  0 -> 1
		totalPage = (int) Math.ceil((double) totalCount / blockCount); // 2
		if (totalPage == 0) {
			totalPage = 1;
		}

		// 현재 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정 (currentPage=1, totalPage =2)
		// 차트연산 		1 > 1 (X) 
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}

		// 현재 페이지의 처음과 마지막 글의 번호 가져오기.(한 페이지의 게시물의 수)	(c = 1, bc = 50)
		startCount = (currentPage - 1) * blockCount;	//	0,
		endCount = startCount + blockCount - 1;			//	49

		// 시작 페이지와 마지막 페이지 값 구하기. (한 화면의 페이지의 수)
		startPage = (int) ((currentPage - 1) / blockPage) * blockPage + 1;	//1
		endPage = startPage + blockPage - 1;								//2
		
		System.out.println("current : " + currentPage);
		
		// 마지막 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		
		pagingHtml = new StringBuffer();
		
		// 이전 block 페이지
		if (currentPage > blockPage) {
			pagingHtml.append("<a href=notice_board.kh?currentPage=" + (startPage - 1) + ">");
			pagingHtml.append("이전");
			pagingHtml.append("</a>");
		}

		pagingHtml.append("&nbsp;|&nbsp;");
		//페이지 번호.현재 페이지는 빨간색으로 강조하고 링크를 제거.
		for (int i = startPage; i <= endPage; i++) {
			if (i > totalPage) {
				System.out.println("i : " + i);
				
				break;
			}
			if (i == currentPage) {
				System.out.println("i : " + i);
				pagingHtml.append("&nbsp;<b><font color='red'>");
				pagingHtml.append(i);
				pagingHtml.append("</font></b>");
			} else {
				System.out.println("i : " + i);
				pagingHtml.append("&nbsp;<a href='notice_board.kh?currentPage=");
				pagingHtml.append(i);
				pagingHtml.append(">");
				pagingHtml.append(i);
				pagingHtml.append("</a>");
			}
			pagingHtml.append("&nbsp;");
		}
		pagingHtml.append("&nbsp;&nbsp;|&nbsp;&nbsp;");

		// 다음 block 페이지
		if (totalPage - startPage >= blockPage) {
			pagingHtml.append("<a href=notice_board.kh?currentPage=" + (endPage + 1) + ">");
			pagingHtml.append("다음");
			pagingHtml.append("</a>");
		}
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public int getStartCount() {
		return startCount;
	}

	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}

	public int getEndCount() {
		return endCount;
	}

	public void setEndCount(int endCount) {
		this.endCount = endCount;
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

	public StringBuffer getPagingHtml() {
		return pagingHtml;
	}

	public void setPagingHtml(StringBuffer pagingHtml) {
		this.pagingHtml = pagingHtml;
	}
}
