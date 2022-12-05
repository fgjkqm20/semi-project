package nbd.qna.model.vo;

import java.util.ArrayList;

public class QnaPageData {

		private ArrayList<Qna> list;
		private String pageNavi;
		public QnaPageData() {
			super();
			// TODO Auto-generated constructor stub
		}
		public QnaPageData(ArrayList<Qna> list, String pageNavi) {
			super();
			this.list = list;
			this.pageNavi = pageNavi;
		}
		public ArrayList<Qna> getList() {
			return list;
		}
		public void setList(ArrayList<Qna> list) {
			this.list = list;
		}
		public String getPageNavi() {
			return pageNavi;
		}
		public void setPageNavi(String pageNavi) {
			this.pageNavi = pageNavi;
		}
		
}
