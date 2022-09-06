package com.loginandregistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginandregistration.models.LoginUser;
import com.loginandregistration.models.User;
import com.loginandregistration.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String renderLogReg(Model model) {
		
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		return "logRegForm.jsp";
	}
	@GetMapping("/dashboard")
	public String renderDashboard(Model model) {
		
		return "dashboard.jsp";
	}
	
	@PostMapping("/register")
	public String regForm(@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result, Model model, HttpSession session) {
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
        userService.register(newUser, result);

        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "logRegForm.jsp";
        }else {
        	// No errors! 
        	// TO-DO Later: Store their ID from the DB in session, 
        	session.setAttribute("userId", newUser.getId());
        	return "redirect:/";
        	// in other words, log them in. 	
        } 
	}
	
	@PostMapping("/login")
	public String logForm(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
		
		User user = userService.login(newLogin, result);
		
		if(result.hasErrors()) {
			//LoginObject is already there
			model.addAttribute("newUser", new User());
			return "logRegForm.jsp";
		}else {
			//Store their ID from DB in session
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getUserName());
			return "redirect:/dashboard";
		}
	}
	
	
	
	
	
}
