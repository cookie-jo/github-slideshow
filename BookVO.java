package model;

public class BookVO {
		private int b_num;    					//책 번호
		private String b_title; 				// 책 제목
		private String b_writer; 				// 작가
		private String b_cateogry; 				// 책 카테고리
		private String b_company;  				// 출판사
		private String b_inventory; 			// 재고 현황
		private String b_rentdate;  			// 대출일
		private String b_duedate;  				// 반납일
		private int b_score;   					// 평점
		private String b_review; 				// 한 줄 평
		private int b_recommend;				// 추천 도서 Y/N
		private int b_m_num;					// 대여 회원번호		
		
		public BookVO() {
			super();
		
		}
		// 전체 출력
		public BookVO(int b_num, String b_title, String b_writer, String b_cateogry, String b_company,
				String b_inventory, String b_rentdate, String b_duedate, int b_score, String b_review, int b_recommend,
				int b_m_num) {
			super();
			this.b_num = b_num;
			this.b_title = b_title;
			this.b_writer = b_writer;
			this.b_cateogry = b_cateogry;
			this.b_company = b_company;
			this.b_inventory = b_inventory;
			this.b_rentdate = b_rentdate;
			this.b_duedate = b_duedate;
			this.b_score = b_score;
			this.b_review = b_review;
			this.b_recommend = b_recommend;
			this.b_m_num = b_m_num;
		}
		
		
		
		// 대여 회원 번호, 추천 번호 삭제 
		public BookVO(int b_num, String b_title, String b_writer, String b_cateogry, String b_company,
				String b_inventory, String b_rentdate, String b_duedate, int b_score, String b_review) {
			super();
			this.b_num = b_num;
			this.b_title = b_title;
			this.b_writer = b_writer;
			this.b_cateogry = b_cateogry;
			this.b_company = b_company;
			this.b_inventory = b_inventory;
			this.b_rentdate = b_rentdate;
			this.b_duedate = b_duedate;
			this.b_score = b_score;
			this.b_review = b_review;
		}
		// 1권 출력 
		public BookVO(int b_num, String b_title, String b_writer, String b_cateogry, String b_company,
				String b_inventory, int b_score, String b_review) {
			super();
			this.b_num = b_num;
			this.b_title = b_title;
			this.b_writer = b_writer;
			this.b_cateogry = b_cateogry;
			this.b_company = b_company;
			this.b_inventory = b_inventory;
			this.b_score = b_score;
			this.b_review = b_review;
		}

		
		
		public BookVO(int b_num, String b_title, String b_writer, String b_cateogry, String b_company,
				String b_inventory, String b_rentdate, int b_score, String b_review) {
			super();
			this.b_num = b_num;
			this.b_title = b_title;
			this.b_writer = b_writer;
			this.b_cateogry = b_cateogry;
			this.b_company = b_company;
			this.b_inventory = b_inventory;
			this.b_rentdate = b_rentdate;
			this.b_score = b_score;
			this.b_review = b_review;
		}

		public int getB_num() {
			return b_num;
		}

		public void setB_num(int b_num) {
			this.b_num = b_num;
		}

		public String getB_title() {
			return b_title;
		}

		public void setB_title(String b_title) {
			this.b_title = b_title;
		}

		public String getB_writer() {
			return b_writer;
		}

		public void setB_writer(String b_writer) {
			this.b_writer = b_writer;
		}

		public String getB_category() {
			return b_cateogry;
		}

		public void setB_category(String b_cateogry) {
			this.b_cateogry = b_cateogry;
		}

		public String getB_company() {
			return b_company;
		}

		public void setB_company(String b_company) {
			this.b_company = b_company;
		}

		public String getB_inventory() {
			return b_inventory;
		}

		public void setB_inventory(String b_inventory) {
			this.b_inventory = b_inventory;
		}

		public String getB_rentdate() {
			return b_rentdate;
		}

		public void setB_rentdate(String b_rentdate) {
			this.b_rentdate = b_rentdate;
		}

		public String getB_duedate() {
			return b_duedate;
		}

		public void setB_duedate(String b_duedate) {
			this.b_duedate = b_duedate;
		}

		public int getB_score() {
			return b_score;
		}

		public void setB_score(int b_score) {
			this.b_score = b_score;
		}

		public String getB_review() {
			return b_review;
		}

		public void setB_review(String b_review) {
			this.b_review = b_review;
		}

		public int getB_m_num() {
			return b_m_num;
		}

		public void setB_m_num(int b_m_num) {
			this.b_m_num = b_m_num;
		}

		public int getB_recommend() {
			return b_recommend;
		}

		public void setB_recommend(int b_recommend) {
			this.b_recommend = b_recommend;
		}

		//@Override
		

		
		public String printBook() {
			return "책번호 : " + b_num + ", 책 제목 : " + b_title + ", 작가 : " + b_writer + ", 분류 : "
					+ b_cateogry + ", 출판사 : " + b_company + ", 평점 : " + b_score + ", 한줄평 : " + b_review
					+"\n";
		}
		@Override
		public String toString() {
			return "[책번호 : " + b_num + ", 책제목 : " + b_title + ", 작가 : " + b_writer + ", 분류 : "
					+ b_cateogry + ", 출판사 : " + b_company + ", 재고 : " + b_inventory + ", 평점 : " + b_score
					+ ", 한줄평 : " + b_review + ", 추천도서 : " + b_recommend + "]\n";
		}
		
		
		public String toStringDate() {
			return "[책번호 : " + b_num + ", 책제목 : " + b_title + ", 작가 : " + b_writer + ", 분류 : "
					+ b_cateogry + ", 출판사 : " + b_company + ", 대출일자  :"
					+ b_rentdate + ", 반납일자 : " + b_duedate + ", 평점 : " + b_score + ", 한줄평 : " + b_review
					+ ", 추천도서 : " + b_recommend + ", 대출현황:ㅣ" + b_m_num + "]";
		}
		
		
}
	