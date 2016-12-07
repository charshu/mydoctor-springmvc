package com.mydoctor.model;

import javax.validation.constraints.Size;

public class NewUserBean
{
		@Size(min = 1, message = "Enter Username.")
		private String username;

		private String password;
		
		private String role;

		public String getPassword()
		{
				return this.password;
		}

		public String getUsername()
		{
				return this.username;
		}

		public void setUsername(String username)
		{
				this.username = username;
		}

		public void setPassword(String password)
		{
				this.password = password;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}


}
