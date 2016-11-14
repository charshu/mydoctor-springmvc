package com.mydoctor.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.mydoctor.model.LoginBean;
import com.mydoctor.service.UserService;


@Controller
@SessionAttributes("username")
public class LoginController
{
	
		
		@Autowired
		private UserService userService;

		@RequestMapping(value="/login", method=RequestMethod.GET)
		public String showLoginPage(ModelMap model)
		{
			
			LoginBean loginBean = new LoginBean();
			model.addAttribute("loginBean", loginBean);
			return "login";
		}
		
		@RequestMapping(value="/login",method=RequestMethod.POST)
		public String executeLogin(ModelMap model, @Valid LoginBean loginBean, BindingResult result) throws SQLException
		{
				
				if(result.hasErrors()){
					return "login";
				}
				String username = loginBean.getUsername();
				String password = loginBean.getPassword();
				boolean isValidUser = userService.isValidUser(username, password);
				if(isValidUser)
				{
					String role = userService.getUserRole(username);
					model.remove("loginBean");
						if("patient".equals(role)){
							model.put("username",username);
							return "welcomePatient";
						}
						else if("doctor".equals(role)){
							return "welcomeDoctor";
						}
						
				}
				else
				{
						model.put("message", "Invalid credentials!!");
						return "login";
				}

				
				return "login";
		}
		
		@RequestMapping(value="/logout",method=RequestMethod.GET)
		public String logout(ModelMap model)
		{	
			
			
			model.clear();
			return "redirect:/login";
		}
		
}
