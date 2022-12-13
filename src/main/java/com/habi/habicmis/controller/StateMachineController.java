package com.habi.habicmis.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.habi.habicmis.model.State;
import com.habi.habicmis.model.StateMachine;
import com.habi.habicmis.service.StateMachineService;

@RestController
public class StateMachineController {

	@Autowired
	private StateMachineService stateMachineService;
	@Autowired
	private StateMachineModelAssembler stateMachineModelAssembler;
	
	
	@GetMapping("/statemachines")
	public CollectionModel<EntityModel<StateMachine>> getStatemachines(){
		
		List<EntityModel<StateMachine>> stateMachineModelList = new ArrayList<EntityModel<StateMachine>>();
		for (StateMachine statemachine : stateMachineService.getStatemachines()) {
			stateMachineModelList.add(stateMachineModelAssembler.toModel(statemachine));
		}
		return CollectionModel.of(stateMachineModelList, 
				linkTo(methodOn(StateMachineController.class).getStatemachines()).withSelfRel());
						
	}

	@GetMapping("/statemachines/{id}")
	public EntityModel<StateMachine> getStatemachineById(@PathVariable Long id){

		Optional<StateMachine> sm = stateMachineService.getById(id);
		
		return stateMachineModelAssembler.toModel(stateMachineService.getById(id).get());
	}

	
	@PostMapping("/statemachines")
	public EntityModel<StateMachine> addStatemachine(@RequestBody StateMachine statemachine) {
		
		stateMachineService.addStateMachine(statemachine);
		
		return stateMachineModelAssembler.toModel(statemachine);
	}
	
	@PostMapping("statemachines/{id}/states")
	public EntityModel<StateMachine> addStatetoStatemachine(@PathVariable Long id, @RequestBody State state){
			
		stateMachineService.addStateToStatemachine(id, state);
		return stateMachineModelAssembler.toModel(stateMachineService.getById(id).get());
		
			
	}
}
