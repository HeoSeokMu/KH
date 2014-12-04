package libraryPage;

public class PagingAction {

    private String actionName; // �׼� �̸�...
    private int currentPage; // ����������
    private int totalCount; // ��ü �Խù� ��
    private int totalPage; // ��ü ������ ��
    private int blockCount; // �� �������� �Խù��� ��
    private int blockPage; // �� ȭ�鿡 ������ ������ ��
    private int startCount; // �� ���������� ������ �Խñ��� ���� ��ȣ
    private int endCount; // �� ���������� ������ �Խñ��� �� ��ȣ
    private int startPage; // ���� ������
    private int endPage; // ������ ������
    private String session_id; //����
    private int rest_num; //���� ��ȣ
    private int ccp; // ������ ������ ��ȣ
    private String rest_localcategory;//����ī�װ�
    private String rest_typecategory;//����ī�װ�
    private StringBuffer pagingHtml; //�����ȯ

    // ������1: String actionName �Ķ���� �߰�
    public PagingAction(String actionName, int currentPage, int totalCount, int blockCount, int blockPage) {

    	this.actionName = actionName;
		this.blockCount = blockCount;
		this.blockPage = blockPage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;

		// ��ü ������ ��
		totalPage = (int) Math.ceil((double) totalCount / blockCount);
		if (totalPage == 0) {
			totalPage = 1;
		}

		// ���� �������� ��ü ������ ������ ũ�� ��ü ������ ���� ����
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}

		// ���� �������� ó���� ������ ���� ��ȣ ��������
		startCount = (currentPage - 1) * blockCount;
		endCount = startCount + blockCount - 1;

		// ���� �������� ������ ������ �� ���ϱ�
		startPage = (int) ((currentPage - 1) / blockPage) * blockPage + 1;
		endPage = startPage + blockPage - 1;

		// ������ �������� ��ü ������ ������ ũ�� ��ü ������ ���� ����
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		// ���� block ������
		pagingHtml = new StringBuffer();
		if (currentPage > blockPage) {
			pagingHtml.append("<li><a href=" + actionName
						+ ".do?currentPage=" + (startPage - 1) + ">");
			pagingHtml.append("����");
			pagingHtml.append("</a></li>");
		}

		// ������ ��ȣ. ���� �������� �Ķ������� �����ϰ� ��ũ�� ����
		for (int i = startPage; i <= endPage; i++) {
			if (i > totalPage) {
				break;
			}
			if (i == currentPage) {
				pagingHtml.append("<li class='active'><a>");
				pagingHtml.append(i);
				pagingHtml.append("</a></li>");
			} else {
				pagingHtml.append("<li><a href=" + actionName
						+ ".do?currentPage=");
				pagingHtml.append(i);
				pagingHtml.append(">");
				pagingHtml.append(i);
				pagingHtml.append("</a><li>");
			}
		}

		// ���� block ������
		if (totalPage - startPage >= blockPage) {
			pagingHtml.append("<li><a href=" + actionName
					+ ".do?currentPage=" + (endPage + 1) + ">");
			pagingHtml.append("����");
			pagingHtml.append("</a></li>");
		}
	}
    // .������1
    
    
    // ������2: ���ų��� ������
    public PagingAction(String actionName, int currentPage, int totalCount, int blockCount, int blockPage, String session_id) {

    	this.actionName = actionName;
		this.blockCount = blockCount;
		this.blockPage = blockPage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.session_id=session_id;

		// ��ü ������ ��
		totalPage = (int) Math.ceil((double) totalCount / blockCount);
		if (totalPage == 0) {
			totalPage = 1;
		}

		// ���� �������� ��ü ������ ������ ũ�� ��ü ������ ���� ����
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}

		// ���� �������� ó���� ������ ���� ��ȣ ��������
		startCount = (currentPage - 1) * blockCount;
		endCount = startCount + blockCount - 1;

		// ���� �������� ������ ������ �� ���ϱ�
		startPage = (int) ((currentPage - 1) / blockPage) * blockPage + 1;
		endPage = startPage + blockPage - 1;

		// ������ �������� ��ü ������ ������ ũ�� ��ü ������ ���� ����
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		// ���� block ������
		pagingHtml = new StringBuffer();
		if (currentPage > blockPage) {
			pagingHtml.append("<li><a href=" + actionName
					+ ".do?session_id="+session_id+"&currentPage=" + (startPage - 1) + ">");
			pagingHtml.append("����");
			pagingHtml.append("</a></li>");
		}

		// ������ ��ȣ. ���� �������� �Ķ������� �����ϰ� ��ũ�� ����
		for (int i = startPage; i <= endPage; i++) {
			if (i > totalPage) {
				break;
			}
			if (i == currentPage) {
				pagingHtml.append("<li class='active'><a>");
				pagingHtml.append(i);
				pagingHtml.append("</a></li>");
			} else {
				pagingHtml.append("<li><a href=" + actionName
						+ ".do?session_id="+session_id+"&currentPage=");
				pagingHtml.append(i);
				pagingHtml.append(">");
				pagingHtml.append(i);
				pagingHtml.append("</a><li>");
			}
		}

		// ���� block ������
		if (totalPage - startPage >= blockPage) {
			pagingHtml.append("<li><a href=" + actionName
					+ ".do?session_id="+session_id+"&currentPage=" + (endPage + 1) + ">");
			pagingHtml.append("����");
			pagingHtml.append("</a></li>");
		}
	}
    // .������2    
    
    // ������3: ���� ������
    public PagingAction(String actionName, int ccp, int totalCount, int blockCount, int blockPage, int rest_num, int currentPage) {

		this.actionName = actionName;
		this.blockCount = blockCount;
		this.blockPage = blockPage;
		this.ccp = ccp;
		this.totalCount = totalCount;
		this.rest_num = rest_num;
		this.currentPage = currentPage;

		// ��ü ������ ��
		totalPage = (int) Math.ceil((double) totalCount / blockCount);
		if (totalPage == 0) {
			totalPage = 1;
		}

		// ���� �������� ��ü ������ ������ ũ�� ��ü ������ ���� ����
		if (ccp > totalPage) {
			ccp = totalPage;
		}

		// ���� �������� ó���� ������ ���� ��ȣ ��������.
		startCount = (ccp - 1) * blockCount;
		endCount = startCount + blockCount - 1;

		// ���� �������� ������ ������ �� ���ϱ�.
		startPage = (int) ((ccp - 1) / blockPage) * blockPage + 1;
		endPage = startPage + blockPage - 1;

		// ������ �������� ��ü ������ ������ ũ�� ��ü ������ ���� ����
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		// ���� block ������
		pagingHtml = new StringBuffer();
		if (ccp > blockPage) {

			pagingHtml.append("<li><a href=" + actionName + ".do?rest_num="+rest_num+"&currentPage="+currentPage+"&ccp="+ (startPage - 1) + ">");
			pagingHtml.append("����");
			pagingHtml.append("</a></li>");
		}

		// ������ ��ȣ. ���� �������� �Ķ������� �����ϰ� ��ũ�� ����.
		for (int i = startPage; i <= endPage; i++) {
			if (i > totalPage) {
				break;
			}
			if (i == ccp) {
				pagingHtml.append("<li class='active'><a>");
				pagingHtml.append(i);
				pagingHtml.append("</a></li>");
			} else {
				pagingHtml.append("<li><a href=" + actionName + ".do?rest_num="+rest_num+"&currentPage="+currentPage+"&ccp=");
				pagingHtml.append(i);
				pagingHtml.append(">");
				pagingHtml.append(i);
				pagingHtml.append("</a><li>");
			}

		}

		// ���� block ������
		if (totalPage - startPage >= blockPage) {
			pagingHtml.append("<li><a href=" + actionName + ".do?rest_num="+rest_num+"&currentPage="+currentPage+"&ccp="
					+ (endPage + 1) + ">");
			pagingHtml.append("����");
			pagingHtml.append("</a></li>");
		}
	}
	// .������3 
    
    
 // ������4: ī�װ� ������
    public PagingAction(String actionName, int currentPage, int totalCount, int blockCount, int blockPage, String rest_localcategory, String rest_typecategory) {
		
    	this.actionName = actionName;
		this.blockCount = blockCount;
		this.blockPage = blockPage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.rest_localcategory = rest_localcategory;
		this.rest_typecategory = rest_typecategory;

		// ��ü ������ ��
		totalPage = (int) Math.ceil((double) totalCount / blockCount);
		if (totalPage == 0) {
			totalPage = 1;
		}

		// ���� �������� ��ü ������ ������ ũ�� ��ü ������ ���� ����
		if (currentPage > totalPage) {
			currentPage = totalPage;
		}

		// ���� �������� ó���� ������ ���� ��ȣ ��������
		startCount = (currentPage - 1) * blockCount;
		endCount = startCount + blockCount - 1;

		// ���� �������� ������ ������ �� ���ϱ�
		startPage = (int) ((currentPage - 1) / blockPage) * blockPage + 1;
		endPage = startPage + blockPage - 1;

		// ������ �������� ��ü ������ ������ ũ�� ��ü ������ ���� ����
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		// ���� block ������
		pagingHtml = new StringBuffer();
		if (currentPage > blockPage) {
			pagingHtml.append("<li><a href=" + actionName
						+ ".do?rest_typecategory="+rest_typecategory+"&rest_localcategory="+rest_localcategory+"&currentPage=" + (startPage - 1) + ">");
			pagingHtml.append("����");
			pagingHtml.append("</a></li>");
		}

		// ������ ��ȣ. ���� �������� �Ķ������� �����ϰ� ��ũ�� ����
		for (int i = startPage; i <= endPage; i++) {
			if (i > totalPage) {
				break;
			}
			if (i == currentPage) {
				pagingHtml.append("<li class='active'><a>");
				pagingHtml.append(i);
				pagingHtml.append("</a></li>");
			} else {
				pagingHtml.append("<li><a href=" + actionName
						+ ".do?rest_typecategory="+rest_typecategory+"&rest_localcategory="+rest_localcategory+"&currentPage=");
				pagingHtml.append(i);
				pagingHtml.append(">");
				pagingHtml.append(i);
				pagingHtml.append("</a><li>");
			}
		}

		// ���� block ������
		if (totalPage - startPage >= blockPage) {
			pagingHtml.append("<li><a href=" + actionName
					+ ".do?rest_typecategory="+rest_typecategory+"&rest_localcategory="+rest_localcategory+"&currentPage=" + (endPage + 1) + ">");
			pagingHtml.append("����");
			pagingHtml.append("</a></li>");
		}
	}
    // .������4

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
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

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public int getRest_num() {
		return rest_num;
	}

	public void setRest_num(int rest_num) {
		this.rest_num = rest_num;
	}

	public int getCcp() {
		return ccp;
	}

	public void setCcp(int ccp) {
		this.ccp = ccp;
	}
}
