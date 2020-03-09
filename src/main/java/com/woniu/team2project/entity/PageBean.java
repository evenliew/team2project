package com.woniu.team2project.entity;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PageBean<T> {

		private List<Plan> beanList;
		private Integer PageSize;
		private Integer PageIndex;
		private Integer totalRecord;
		private Integer totalPage;
		public List<Plan> getBeanList() {
			return beanList;
		}
		public void setBeanList(List<Plan> beanList) {
			this.beanList = beanList;
		}
		public Integer getPageSize() {
			return PageSize;
		}
		public void setPageSize(Integer pageSize) {
			PageSize = pageSize;
		}
		public Integer getPageIndex() {
			return PageIndex;
		}
		public void setPageIndex(Integer pageIndex) {
			PageIndex = pageIndex;
		}
		public Integer getTotalRecord() {
			return totalRecord;
		}
		public void setTotalRecord(Integer totalRecord) {
			this.totalRecord = totalRecord;
		}
		public Integer getTotalPage() {
			return (totalRecord%PageSize==0)?totalRecord/PageSize:totalRecord/PageSize+1;
		}
		public void setTotalPage(Integer totalPage) {
			this.totalPage = totalPage;
		}
		@Override
		public String toString() {
			return "PageBean [beanList=" + beanList + ", PageSize=" + PageSize + ", PageIndex=" + PageIndex
					+ ", totalRecord=" + totalRecord + ", totalPage=" + totalPage + "]";
		}
		public PageBean(List<Plan> beanList, Integer pageSize, Integer pageIndex, Integer totalRecord,
				Integer totalPage) {
			super();
			this.beanList = beanList;
			PageSize = pageSize;
			PageIndex = pageIndex;
			this.totalRecord = totalRecord;
			this.totalPage = totalPage;
		}
		public PageBean() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
}
