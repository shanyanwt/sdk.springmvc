package com.sdk.util;

/**
 * 分页工具类
 *
 * @author YanJiang 2018年1月10日
 *
 */
public class PageUtil {
	/*
	 * 总条数
	 */
	private int toalRecord;
	/* 每页多少条 */
	private int pageSize = 10;

	// 总页数
	private int totalPage;
	// 当前页
	private int currentPage;
	// 上一页
	private int prePage;
	// 下一页
	private int nextPage;
	/*
	 * 当前对应的条数 开始
	 * 如每页10条，
	 * 1 1
	 * 2 11
	 * 3 21
	 */
	private int currRecord;

	/**
	 * @return 总条数
	 */
	public int getToalRecord() {
		return toalRecord;
	}

	/**
	 * @param 总条数
	 */
	public void setToalRecord(int toalRecord) {
		this.toalRecord = toalRecord;
	}

	/**
	 * @return 每页多少条 默认10条
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param 每页多少条
	 *            默认10条
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return 总页数
	 */
	public int getTotalPage() {

		/**
		 * 总页数计算
		 */
		if (this.toalRecord % this.pageSize == 0) {
			this.totalPage = this.toalRecord / this.pageSize;
		} else {
			this.totalPage = this.toalRecord / this.pageSize + 1;
		}
		return totalPage;
	}

	/**
	 * @param 总页数
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return 当前页
	 */
	public int getCurrentPage() {
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}
		if (this.getTotalPage() > 1 && this.currentPage > this.getTotalPage()) {
			this.currentPage = this.getTotalPage();
		}

		return currentPage;
	}

	/**
	 * @param 当前页
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return 上一页
	 */
	public int getPrePage() {
		this.prePage = this.getCurrentPage() - 1;
		if (this.prePage < 1) {
			this.prePage = 1;
		}
		return prePage;
	}

	/**
	 * @return 下一页
	 */
	public int getNextPage() {
		this.nextPage = this.getCurrentPage() + 1;
		if (this.getTotalPage() > 0 && this.nextPage > this.getTotalPage()) {
			this.nextPage = this.getTotalPage();
		}
		return nextPage;
	}

	/**
	 * @return the 当前页
	 */
	public int getCurrRecord() {
		this.currRecord = (this.getCurrentPage() - 1) * this.pageSize;
		return currRecord;
	}

	// 测试
	public static void main(String[] ager) {
		PageUtil page = new PageUtil();
		page.setToalRecord(51);
		page.setPageSize(5);
		System.out.println(page);
	}

	@Override
	public String toString() {
		return "分页结果 [toalRecord=" + this.getToalRecord() + ", pageSize="
				+ this.getPageSize() + ", totalPage=" + this.getTotalPage()
				+ ", currentPage=" + this.getCurrentPage() + ", prePage="
				+ this.getPrePage() + ", nextPage=" + this.getNextPage()
				+ ", currRecord=" + this.getCurrRecord() + "]";
	}

}
