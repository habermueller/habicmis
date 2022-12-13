package com.habi.habicmis.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.habi.habicmis.model.StateMachine;


@Component
public class StateMachineModelAssembler implements RepresentationModelAssembler<StateMachine, EntityModel<StateMachine>> {

	@Override
	public EntityModel<StateMachine> toModel(StateMachine stateMachine) {
		return EntityModel.of(stateMachine ,
				linkTo(methodOn(StateMachineController.class).getStatemachineById(stateMachine.getId())).withSelfRel(),
				linkTo(methodOn(StateMachineController.class).getStatemachines()).withRel("statemachines")
				);
	
	}

}
