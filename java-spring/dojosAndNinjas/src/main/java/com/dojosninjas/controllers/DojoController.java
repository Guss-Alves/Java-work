package com.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojosninjas.models.Dojo;
import com.dojosninjas.services.DojoService;

@Controller
public class DojoController {

	@Autowired
	private DojoService dojoService;
	
	//RENDER MAIN PAGE
	@GetMapping("/")
	public String homePage(@ModelAttribute("dojo") Dojo dojo, Model model) {
		
		model.addAttribute("dojos", dojoService.allDojos());
		return "home.jsp";
	}
	//RENDER NICE package
	@GetMapping("/nice")
	public String nicePage() {
		return "nice.jsp";
	}
	//FORM TO CREATE DOJO
	@PostMapping("/")
	public String processDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "home.jsp";
		}else {
			dojoService.createDojo(dojo);
			return "redirect:/nice";
		}
	}
	
	//DISPLAY DOJO AND NINJAS
	@GetMapping("/show/dojo/{id}")
	public String renderDisplay(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.oneDojo(id));
		return "dashboard.jsp";
	}
	
}
