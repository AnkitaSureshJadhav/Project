package com.controller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.APIDemo.Register;
import com.example.APIDemo.User;
import com.model.Category;
import com.model.Product;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Webapi {
	@Autowired
	SessionFactory factory;
	
	
	@RequestMapping("/categoryinfo")
	public String categoryinfo() {
		
		return"categoryinfo";
	}

	@RequestMapping("/Productinfo")
	 public String product() {
		 
		 return "Productinfo";
	}
	
		 @RequestMapping("/Productmanagement")
		 public String Productmanagement() {
			 
			 return "Productmanagement";
}

	@RequestMapping("savedata")
	ModelAndView savedata(Register user,HttpServletRequest request)
	{
		MultipartFile filedata=user.getImages();
		
		// MultipartFile object contains image data
		
		String filename=filedata.getOriginalFilename();
		
		System.out.println(filename);
		 String[] strings=filename.split("\\.");
		 String fileextensionS= strings[1];
		
		File file=new File(request.getServletContext().getRealPath("/images"),filename);
				
		try {
			
			filedata.transferTo(file);
			
			System.out.println("File uploaded successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView modelAndView = new ModelAndView();
		
	    Session session = factory.openSession();
		
	    Transaction tx=session.beginTransaction();
	    
	    	user.setImagepath(filename); // 
	    	session.save(user);
	    	
	    tx.commit();
	    
	    modelAndView.addObject("message","Registration successful");
	    
	    modelAndView.setViewName("login");
	    
	    return modelAndView;
	    
	}
	
	@RequestMapping("saveProduct")
	public ModelAndView addProduct(Product product,HttpServletRequest request,int cid)
	{

		MultipartFile filedata=product.getImages();
		String filename=filedata.getOriginalFilename();
		
		System.out.println(filename);// one.jpg
		String[] strings =filename.split("\\.");
		String fileextension= strings[1];

		File file=new File(request.getServletContext().getRealPath("/images"),filename);
				
		try {
			
			filedata.transferTo(file);
			
			System.out.println("File uploaded successfully");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		

		ModelAndView modelAndView = new ModelAndView();
		
           Session session=factory.openSession();
		
		Category category=session.load(Category.class,cid);
		
		System.out.println("Products from given catergory are :- " + category.getProducts());
		
		/* get list of product and add product into it  */
		
		List<Product> productlist=category.getProducts();
					
		Transaction transaction=session.beginTransaction();
		
			product.setImagepath(filename);// updating imagepath
	    
			productlist.add(product);
						
		transaction.commit();
				
		System.out.println("product added into database");
	
	    
		modelAndView.addObject("message","Product information is saved successfully");
	    
	    modelAndView.setViewName("Productmanagement");
	    
	    return modelAndView;
	    
	}


}