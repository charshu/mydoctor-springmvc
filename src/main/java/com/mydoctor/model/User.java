package com.mydoctor.model;

public abstract class User {
	
	protected int id;
	protected String username;
	protected String password;
	protected String role;

		public User() {
			// TODO Auto-generated constructor stub
		}
		public User(int id,String username,String password,String role) {
			// TODO Auto-generated method stub
			this.id = id;
			this.username = username;
			this.password = password;
			this.role = role;

		}
		public void setId(int id) {
		this.id = id;
		}
		public int getId() {
		return id;
		}	
		public String getPassword() {
         return password;
		}

		public void setPassword(String password) {
         this.password = password;
		}
			
		public String getUsername() {
         return username;
		}

		public void setUserName(String username) {
         this.username = username;
		}
		public String getRole() {
          return role;
 		}

		public void setRole(String role) {
          this.role = role;
 		}
		

	
}
