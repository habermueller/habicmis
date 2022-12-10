package com.habi.habicmis.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity

public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL)	
	@JoinColumn
	private StateMachine statemachine;


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}


	public StateMachine getStatemachine() {
		return statemachine;
	}

	public void setStatemachine(StateMachine statemachine) {
		this.statemachine = statemachine;
	}
	
	public State (String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	
}
