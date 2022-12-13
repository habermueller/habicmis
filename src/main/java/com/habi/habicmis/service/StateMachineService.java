package com.habi.habicmis.service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habi.habicmis.model.State;
import com.habi.habicmis.model.StateMachine;
import com.habi.habicmis.repository.StateMachineRepository;

@Service
public class StateMachineService {

	@Autowired
	private StateMachineRepository stateMachineRepository;
	
	public void addStateMachine(StateMachine stateMachine) {
		stateMachineRepository.save(stateMachine);
	}
	
	public void addStateToStatemachine(Long id, State state) {
		StateMachine sm = stateMachineRepository.findById(id).get();
		sm.addState(state);
		
		stateMachineRepository.save(sm);
	}
	

	public Collection<StateMachine> getStatemachines() {
		return stateMachineRepository.findAll();
		
	}
	
	public Optional<StateMachine> getById(Long id) {
		return stateMachineRepository.findById(id);
	}
	
}
