package com.example.APIDemo;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	
	@Autowired 
	 SessionFactory factory;
	@RequestMapping("/login")
	public String login() {
		
		return"login";
		
	}
	@RequestMapping("/validate")
	public ModelAndView validate(Register userfromBrowser)
	{
		ModelAndView  modelAndView = new ModelAndView();
		
		String username=userfromBrowser.getUsername();
		String password= userfromBrowser.getPassword();
		if(username.equals("admin") && password.equals("admin123")) {
			modelAndView.setViewName("categoryinfo");
		}
		else if(username.equals("merchant")&& password.equals("merchant123"))
		{
			modelAndView.setViewName("Productmanagement");

			
		}
		else {

		Session session = factory.openSession();
		 
		Register userfromDatabase =session.get(Register.class,username);
		if(userfromBrowser!=null) 
		{
		if(userfromBrowser.getPassword().equals(userfromDatabase.getPassword()))
		{
			modelAndView.addObject("username",username);
			modelAndView.addObject("username",userfromDatabase.getImagepath());

			modelAndView.setViewName("productinfo");
		}
		else
		{
			modelAndView.addObject("message","wrong password");
			modelAndView.setViewName("login");
			
		}
		
		}
		else 
		{
			modelAndView.addObject("message","wrong credentials");
			modelAndView.setViewName("login");
		}
	
		return modelAndView ;
      
		}
		return modelAndView;
	}
	@RequestMapping("register")
	public String register() {
		
		return"register";
		
	}
	
	@RequestMapping("registration")
	ModelAndView savedata(Register register) 
	{
		ModelAndView modelAndView = new ModelAndView();
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.save(register);
		transaction.commit();
		
		modelAndView.addObject("message","Registration sucessful");
		modelAndView.setViewName("login");
		return modelAndView;
		
	}
	@RequestMapping("/forgatepassword")
	public String forgatePassword() {
		
		return"forgatepassword";
	
	
	
	
	}
	@RequestMapping("forgate")
	public ModelAndView forgatepassword(User userfromBrowser)
	{
		ModelAndView  modelAndView = new ModelAndView();

		Session session = factory.openSession();
		 
		User userfromDatabase =session.load(User.class,userfromBrowser.getUsername());
		
		if(userfromBrowser.getPassword().equals(userfromDatabase.getPassword()))
		{
			modelAndView.addObject("username",userfromDatabase.getUsername());
			modelAndView.setViewName("login");

		}else {
			modelAndView.addObject("password",userfromDatabase.getUsername());
			modelAndView.setViewName("login");


		}
		return modelAndView;
	}
	@RequestMapping("/Aboutus")
	public String AboutUs() {
		
		return"Aboutus";
	}
	
		
		
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	



	


