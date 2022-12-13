package com.habi.habicmis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StateTransition {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "statemachine")
	private StateMachine statemachine;
		
	@ManyToOne()
	@JoinColumn(name = "fromstate")
	private State fromState;

	@ManyToOne()		
	@JoinColumn(name = "tostate")
	private State toState;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StateMachine getStatemachine() {
		return statemachine;
	}

	public void setStatemachine(StateMachine statemachine) {
		this.statemachine = statemachine;
	}

	public State getFromState() {
		return fromState;
	}

	public void setFromState(State fromState) {
		this.fromState = fromState;
	}

	public State getToState() {
		return toState;
	}

	public void setToState(State toState) {
		this.toState = toState;
	}
	
	public StateTransition(State fromState, State toState) {
		this.fromState = fromState;
		this.toState = toState;
	}
	
	
	
}
