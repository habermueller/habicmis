package com.habi.habicmis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.habi.habicmis.model.State;
import com.habi.habicmis.repository.StateRepository;

@RestController
public class StateController {

	@Autowired
	private StateRepository stateRepository;
	
	@PostMapping("/states")
	State addState(@RequestBody State state) {
	
		 return stateRepository.save(state);
		 
	}
}
