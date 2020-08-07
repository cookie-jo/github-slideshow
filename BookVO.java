package admin.model;
public class BookVO {

	private int b_num; // 책 번호
	private String b_title; // 책 제목
	private String b_writer; // 작가
	private String b_category; // 책 카테고리
	private String b_company; // 출판사
	private int b_score; // 평점
	private String b_review; // 한 줄 평
	private String b_inventory; // 재고 현황
	private String b_date; // 반납 기일
	//private String b_recommend;//추천값

	public BookVO() {
		super();

	}

	public BookVO(int b_num, String b_title, String b_writer, String b_category, String b_company, int b_score,
			String b_review, String b_inventory, String b_date) {
		super();
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_writer = b_writer;
		this.b_category = b_category;
		this.b_company = b_company;
		this.b_score = b_score;
		this.b_review = b_review;
		this.b_inventory = b_inventory;
		this.b_date = b_date;
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
		return b_category;
	}

	public void setB_category(String b_category) {
		this.b_category = b_category;
	}

	public String getB_company() {
		return b_company;
	}

	public void setB_company(String b_company) {
		this.b_company = b_company;
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

	public String getB_inventory() {
		return b_inventory;
	}

	public void setB_inventory(String b_inventory) {
		this.b_inventory = b_inventory;
	}

	public String getB_date() {
		return b_date;
	}

	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

	@Override
	public String toString() {
		return "BookVO [b_num=" + b_num + ", b_title=" + b_title + ", b_writer=" + b_writer + ", b_category="
				+ b_category + ", b_company=" + b_company + ", b_score=" + b_score + ", b_review=" + b_review
				+ ", b_inventory=" + b_inventory + ", b_date=" + b_date + "]";
	}

}
