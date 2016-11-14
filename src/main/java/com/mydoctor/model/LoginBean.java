package com.mydoctor.model;

import javax.validation.constraints.Size;

public class LoginBean
{
		@Size(min = 1, message = "Enter Username.")
		private String username;

		private String password;

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


}
