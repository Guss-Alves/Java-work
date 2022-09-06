package com.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojosninjas.models.Dojo;
import com.dojosninjas.models.Ninja;
import com.dojosninjas.services.DojoService;
import com.dojosninjas.services.NinjaService;

@Controller
public class NinjaController {

	@Autowired
	private NinjaService ninjaService;
	
	@Autowired
	private DojoService dojoService;
	
	//render Form
	@GetMapping("/ninja")
	public String renderNinjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
		
		List<Dojo> dojoList = dojoService.allDojos();
		model.addAttribute("dojo", dojoList);
		
		return "ninjaForm.jsp";
	}
	//process the form 
	@PostMapping("/ninja/new")
	public String processNinja(@Valid @ModelAttribute("ninja") Ninja ninja,BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Dojo> dojoList = dojoService.allDojos();
			model.addAttribute("dojo", dojoList);
			return "ninjaForm.jsp";
		}else {
			ninjaService.createNinja(ninja);
			return "redirect:/show/dojo/"+ ninja.getDojo().getId();
		}
	}
	
}
