package com.mydoctor.model;

public abstract class User {
	
	protected String id;
	protected String username;
	protected String password;
	protected String role;

		public User() {
			// TODO Auto-generated constructor stub
		}
		public User(String id,String username,String password,String role) {
			// TODO Auto-generated method stub
			this.id = id;
			this.username = username;
			this.password = password;
			this.role = role;

		}
		public void setId(String id) {
		this.id = id;
		}
		public String getId() {
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
