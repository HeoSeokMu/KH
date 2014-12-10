package member.controller;

public class pagingAction {

	private int currentPage; // ����������
	private int totalCount;	 // ��ü �Խù� ��
	private int totalPage;	 // ��ü ������ ��
	private int blockCount;	 // �� ��������  �Խù��� ��
	private int blockPage;	 // �� ȭ�鿡 ������ ������ ��
	private int startCount;	 // �� ���������� ������ �Խñ��� ���� ��ȣ
	private int endCount;	 // �� ���������� ������ �Խñ��� �� ��ȣ
	private int startPage;	 // ���� ������
	private int endPage;	 // ������ ������
	
	private StringBuffer pagingHtml;

	// ����¡ ������
	public pagingAction(int currentPage, int totalCount, int blockCount, int blockPage) {
		System.out.println("blockCount : " + blockCount);

		this.blockCount = blockCount;
		this.blockPage = blockPage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;

		// ��ü ������ ��    							  11	/	   10
		// ��Ʈ ����								  17	/	   50	//  0 -> 1
		totalPage = (int) Math.ceil((double) totalCount / blockCount); // 2
		if (totalPage == 0) {
			totalPage = 1;
		}

		// ���� �������� ��ü ������ ������ ũ�� ��ü ������ ���� ���� (currentPage=1, totalPage =2)
		// ��Ʈ���� 		1 > 1 (X) 
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}

		// ���� �������� ó���� ������ ���� ��ȣ ��������.(�� �������� �Խù��� ��)	(c = 1, bc = 50)
		startCount = (currentPage - 1) * blockCount;	//	0,
		endCount = startCount + blockCount - 1;			//	49

		// ���� �������� ������ ������ �� ���ϱ�. (�� ȭ���� �������� ��)
		startPage = (int) ((currentPage - 1) / blockPage) * blockPage + 1;	//1
		endPage = startPage + blockPage - 1;								//2
		
		System.out.println("current : " + currentPage);
		
		// ������ �������� ��ü ������ ������ ũ�� ��ü ������ ���� ����
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		
		pagingHtml = new StringBuffer();
		
		// ���� block ������
		if (currentPage > blockPage) {
			pagingHtml.append("<a href=notice_board.kh?currentPage=" + (startPage - 1) + ">");
			pagingHtml.append("����");
			pagingHtml.append("</a>");
		}

		pagingHtml.append("&nbsp;|&nbsp;");
		//������ ��ȣ.���� �������� ���������� �����ϰ� ��ũ�� ����.
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

		// ���� block ������
		if (totalPage - startPage >= blockPage) {
			pagingHtml.append("<a href=notice_board.kh?currentPage=" + (endPage + 1) + ">");
			pagingHtml.append("����");
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
