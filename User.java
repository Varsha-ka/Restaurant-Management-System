package com.Tap.Model;

import java.sql.Date;

public class User {
	
	    private int userId;
	    private String name;
	    private String userName;
	    private String password;
	    private String email;
	    private String phone;
	    private String address;
	    private String role;
	    private Date createDate;
	    private Date lastLoginDate;

	    public User() {}

	    public User(int userId, String name, String userName, String password, String email, String phone, String address,
	                String role, Date createDate, Date lastLoginDate) {
	        this.userId = userId;
	        this.name = name;
	        this.userName = userName;
	        this.password = password;
	        this.email = email;
	        this.phone = phone;
	        this.address = address;
	        this.role = role;
	        this.createDate = createDate;
	        this.lastLoginDate = lastLoginDate;
	    }

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public Date getCreateDate() {
			return createDate;
		}

		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}

		public Date getLastLoginDate() {
			return lastLoginDate;
		}

		public void setLastLoginDate(Date lastLoginDate) {
			this.lastLoginDate = lastLoginDate;
		}
		
		@Override
		public String toString() {
		return	userId+" "+name+" "+userName+" "+password+" "+email+" "+phone+" "+ address+
		   " "+ role+" "+ createDate+" "+ lastLoginDate;
					

		}

	


}
