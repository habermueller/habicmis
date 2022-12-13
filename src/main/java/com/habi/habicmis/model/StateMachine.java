package com.habi.habicmis.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class StateMachine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private State startState;
	
	
	@OneToMany(mappedBy = "statemachine", cascade = CascadeType.ALL)
	private List<State> states = new ArrayList<>();
	

	@OneToMany(mappedBy = "statemachine")
	private List<StateTransition> stateTransitions ;



	public StateMachine(int id) {
		this.id = Long.valueOf(id);
	}

//	@JsonCreator
//	public StateMachine(@JsonProperty("id") int id) {
//		this.id = Long.valueOf(id);
//	}
	
	public StateMachine() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}


	public State getStartState() {
		return startState;
	}

	
	public void setStartState(State startState) {
		this.startState = startState;
	}
	

	public List<StateTransition> getStateTransitions() {
		return stateTransitions;
	}
	
	@JsonManagedReference
	public List<State> getStates() {
		return states;
	}

	public void addState(State aState) {
		
		aState.setStatemachineid(this.getId());
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


	public void setStates(List<State> states) {
		this.states = states;
	} 
				
	
	
	
}
