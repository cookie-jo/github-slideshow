package model;

public class AdminVO {
	//관리자 a_num,  a_id, a_password,  a_name,  a_tel,  a_email,  a_books
	//1. AdminVO로 위 변수들을 한번에 묶을 수 있는 새로운 자료형을 만든다.
	private int a_num; //관리자코드
	private String a_id; //
	private String a_password;
	private String a_name;
	private String a_tel;
	private String a_email;
	private String a_book;
	public AdminVO() {   }
	public AdminVO(int a_num, String a_id, String a_password, String a_name, String a_tel, String a_email,
			String a_book) {
		super();
		this.a_num = a_num;
		this.a_id = a_id;
		this.a_password = a_password;
		this.a_name = a_name;
		this.a_tel = a_tel;
		this.a_email = a_email;
		this.a_book = a_book;
	}
	public int getA_num() {
		return a_num;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getA_password() {
		return a_password;
	}
	public void setA_password(String a_password) {
		this.a_password = a_password;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public String getA_tel() {
		return a_tel;
	}
	public void setA_tel(String a_tel) {
		this.a_tel = a_tel;
	}
	public String getA_email() {
		return a_email;
	}
	public void setA_email(String a_email) {
		this.a_email = a_email;
	}
	public String getA_book() {
		return a_book;
	}
	public void setA_book(String a_book) {
		this.a_book = a_book;
	}
	@Override
	public String toString() {
		return "AdminVO [a_num=" + a_num + ", a_id=" + a_id + ", a_password=" + a_password + ", a_name=" + a_name
				+ ", a_tel=" + a_tel + ", a_email=" + a_email + ", a_book=" + a_book + "]";
	}

}
