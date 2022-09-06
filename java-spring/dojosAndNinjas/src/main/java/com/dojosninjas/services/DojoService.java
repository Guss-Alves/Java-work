package com.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojosninjas.models.Dojo;
import com.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	private DojoRepository dojoRepo;
	
	//GET ALL DOJOS
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	//GET ONE 
	public Dojo oneDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else {
			return null;
		}
	}
	
	//CREATE 
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	
}
