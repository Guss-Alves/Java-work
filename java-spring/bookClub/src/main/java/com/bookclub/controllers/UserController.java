package com.bookclub.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.bookclub.models.Book;
import com.bookclub.models.LoginUser;
import com.bookclub.models.User;
import com.bookclub.services.BookService;
import com.bookclub.services.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;

	
	//DISPLAY THE LOG AND REG
	@GetMapping("/")
	public String renderLogReg(Model model) {
		
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		return "logRegForm.jsp";
	}
	
	
	//LOGIC TO REGISTER
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
	
	//LOGIC TO LOGIN
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
	
	//LOGIC TO LOGOUT
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//LOGIC FOR THE DASHBOARD
	@GetMapping("/dashboard")
	public String renderDashboard(HttpSession session, Model model) {
		if(session.getAttribute("userId") == null ) {
			return "redirect:/";
		}
		List<Book> bookList = bookService.allBooks();
		model.addAttribute("books", bookList);
		
		return "dashboard.jsp";
	}
	
	//LOGIC TO CREATE A BOOK
	@GetMapping("/book/new")
	public String renderBookForm(@ModelAttribute("book") Book book) {
	
		return "bookForm.jsp";
	}
	
	@PostMapping("/book/new")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "bookForm.jsp";
		}else {
			bookService.createBook(book);
			return "redirect:/dashboard";
			
		}
	}

	//LOGIC TO SHOW ONE SINGLE ITEM
	@GetMapping("/book/show/{id}")
	public String oneBook(@PathVariable("id") Long id, Model model ) {
		Book foundBook = bookService.oneBook(id);
		
		//NOW I NEED ADD IT TO THE MODEL IN ORDER TO USE ON FRONT-END
		model.addAttribute("foundBook", foundBook);
		return "details.jsp";
		
	}
	
	//LOGIC TO UPDATE A BOOKS
	@GetMapping("/book/edit/{id}")
	public String updateBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		Book foundBook = bookService.oneBook(id);
		//NOW I NEED ADD IT TO THE MODEL IN ORDER TO USE ON FRONT-END
		model.addAttribute("foundBook", foundBook);
		
		Long userId = (Long)session.getAttribute("userId");
//		model.addAttribute("userId", userId);
		
		//check if the id of user in session is the same of the book creator id
		if(userId == foundBook.getUser().getId()) {
			
			return "editBook.jsp";
		}else {
			return "redirect:/dashboard";
		}
		
	}
	
	@PutMapping("/book/edit/{id}")
	public String proccessBookUpdate(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			Book foundBook = bookService.oneBook(id);
			model.addAttribute("foundBook", foundBook);
			
			return "editBook.jsp";
		}else {
			bookService.createBook(book);
			return "redirect:/dashboard";
			
		}
	}
	
	//LOGIC TO DELETE A BOOK
	@DeleteMapping("/book/delete/{id}")
	public String processDelete(@PathVariable("id") Long id) {
		
		bookService.deleteBook(id);
		return "redirect:/dashboard";
		
	}

	
}

