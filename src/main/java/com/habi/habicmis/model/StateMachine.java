package com.habi.habicmis.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity

public class StateMachine {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private State startState;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<State> states = new HashSet<>();
	


	@OneToMany
	private Set<StateTransition> stateTransitions = new HashSet<>();


	public Long getId() {
		return id;
	}


	public State getStartState() {
		return startState;
	}

	public void setStartState(State startState) {
		this.startState = startState;
	}
	

	public Set<StateTransition> getStateTransitions() {
		return stateTransitions;
	}
	
	public Set<State> getStates() {
		return states;
	}

	public void addState(State aState) {
		states.add(aState);
	}
	
	public void addStateTransition(StateTransition stateTransition) throws StateisNotMemberOfMachineException {
		
		State fromState = stateTransition.getFromState();
		State toState = stateTransition.getToState();
		
		// Make sure that from and to state is contained Machines State
		if (! this.getStates().contains(fromState))
			throw new StateisNotMemberOfMachineException(this, fromState );	
		if (! this.getStates().contains(toState))
			throw new StateisNotMemberOfMachineException(this, toState );	
		
		} 
				
	
	
	
}
