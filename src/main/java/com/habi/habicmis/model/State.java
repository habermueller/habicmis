package com.habi.habicmis.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String description;
	
	
	@ManyToOne	
	@JoinColumn(name = "statemachineid", insertable = false, updatable = false, nullable = false)
	private StateMachine statemachine;
	
	private Long statemachineid;

	
	public State() {
		
	}
	
	
	
	public String getDescription() {
		return description;
	}


	public void setId(Long id) {
		this.id = id;
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


	@JsonBackReference
	public StateMachine getStatemachine() {
		return statemachine;
	}

	
	public State (String name, String description) {
		this.name = name;
		this.description = description;
	}


	public Long getStatemachineid() {
		return statemachineid;
	}


	public void setStatemachineid(Long statemachineid) {
		this.statemachineid = statemachineid;
	}
	
	
}
