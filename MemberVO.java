package model;

public class MemberVO {
		private int m_num; 
		private String m_id;
		private String m_password;
		private String m_name;
		private String m_email;
		private String m_addr;
		private String m_tel;
		private String m_birthday;
		
		public MemberVO() {}

		public MemberVO(int m_num, String m_id, String m_password, String m_name, String m_email, String m_addr,
				String m_tel, String m_birthday) {
			super();
			this.m_num = m_num;
			this.m_id = m_id;
			this.m_password = m_password;
			this.m_name = m_name;
			this.m_email = m_email;
			this.m_addr = m_addr;
			this.m_tel = m_tel;
			this.m_birthday = m_birthday;
		}

		public int getM_num() {
			return m_num;
		
		}

		public void setM_num(int m_num) {
			this.m_num = m_num;
		}

		public String getM_id() {
			return m_id;
		}

		public void setM_id(String m_id) {
			this.m_id = m_id;
		}

		public String getM_password() {
			return m_password;
		}

		public void setM_password(String m_password) {
			this.m_password = m_password;
		}

		public String getM_name() {
			return m_name;
		}

		public void setM_name(String m_name) {
			this.m_name = m_name;
		}

		public String getM_email() {
			return m_email;
		}

		public void setM_email(String m_email) {
			this.m_email = m_email;
		}

		public String getM_addr() {
			return m_addr;
		}

		public void setM_addr(String m_addr) {
			this.m_addr = m_addr;
		}

		public String getM_tel() {
			return m_tel;
		}

		public void setM_tel(String m_tel) {
			this.m_tel = m_tel;
		}

		public String getM_birthday() {
			return m_birthday;
		}

		public void setM_birthday(String m_birthday) {
			this.m_birthday = m_birthday;
		}

		@Override
		public String toString() {
			return "[회원번호 : " + m_num + ", 아이디 : " + m_id + ", 비밀번호 : " + m_password + ", 이름 : " + m_name
					+ ", 이메일주소 : =" + m_email + ", 주소 : " + m_addr + ", 전화번호 : " + m_tel + ", 생년월일 : " + m_birthday
					+ "]";
		}
		
		
		

}
