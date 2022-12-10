package com.habi.habicmis.model;

public class StateisNotMemberOfMachineException extends Exception {
	private StateMachine stateMachine;
	private State state;
	public StateisNotMemberOfMachineException(StateMachine stateMachine, State state) {
		this.stateMachine = stateMachine;
		this.state = state;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
