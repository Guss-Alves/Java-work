package com.dojosninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojosninjas.models.Ninja;
import com.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepository ninjaRepo;
	
	//GET ALL NINJAS
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	//CREATE NINJAS
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	
}
