package com.mccoy.hanu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController 
{
	@RequestMapping("/add1")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response)
	{
		int i= Integer.parseInt(request.getParameter("t1"));
		int j= Integer.parseInt(request.getParameter("t2"));
		
		AddService as= new AddService();
		int k=as.add(i, j);
		
		ModelAndView mv= new ModelAndView();
		mv.setViewName("index1.jsp");
		mv.addObject("result", k);
		return mv;
		//System.out.println("in ADD CONTROLLER");
	}
	
	

}
