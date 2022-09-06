package com.omijuki.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@RequestMapping("/")
	public String displayForm() {
		return "home.jsp";
	}
	
	@RequestMapping(value="/process/form", method=RequestMethod.POST)
	public String processForm(@RequestParam(value="year") Integer year,
							  @RequestParam(value="city") String city,
							  @RequestParam(value="name") String name,
							  @RequestParam(value="hobby")String hobby,
							  @RequestParam(value="livingThing") String livingThing,
							  @RequestParam(value="message") String message,
							  HttpSession session) {
		
//		Integer Year = (Integer) session.getAttribute(year);
//		session.setAttribute("Year", year);
		
		Integer Year = (Integer) session.getAttribute(null);
		session.setAttribute("Year", year);
		
		String City = (String) session.getAttribute(city);
		session.setAttribute("City", city);
		
		String fName = (String) session.getAttribute(name);
		session.setAttribute("fName", name);
		
		String Hobby = (String) session.getAttribute(hobby);
		session.setAttribute("Hobby", hobby);
		
		String LivingThing = (String) session.getAttribute(livingThing);
		session.setAttribute("LivingThing", livingThing);
		
		String Message = (String) session.getAttribute(livingThing);
		session.setAttribute("Message", message);
		
		System.out.println("info submitted: " + year + city + name + hobby + livingThing + message);
		return "redirect:/dashboard";
	}
	@RequestMapping("/dashboard")
	public String displayDashboard() {
		return "dashboard.jsp";
	}
}
