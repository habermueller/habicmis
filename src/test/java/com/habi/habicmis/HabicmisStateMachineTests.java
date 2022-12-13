package com.habi.habicmis;

import static org.assertj.core.api.Assertions.assertThat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.habi.habicmis.model.State;
import com.habi.habicmis.model.StateMachine;
import com.habi.habicmis.model.StateTransition;
import com.habi.habicmis.model.StateisNotMemberOfMachineException;
import com.habi.habicmis.repository.StateMachineRepository;
import com.habi.habicmis.repository.StateRepository;


//@SpringBootTest
@DataJpaTest
public class HabicmisStateMachineTests {

	@Autowired
	StateMachineRepository smRepo;
	
	@Autowired
	StateRepository stateRepo;

	
	private final static Logger log = LoggerFactory.getLogger(HabicmisStateMachineTests.class);	
	
	@Test
	void createStatemachineTest() {
				
		StateMachine sm = new StateMachine();
		
		sm.addState(new State("StartState", "This is the Start State of the Machine" ));		
		
		smRepo.save(sm);
		
		log.trace("The Statemachine looks like this" + sm.toString());
		
		assertThat(sm.getId()).isNotNull();
	}
	
	
	@Test
	void addStateToStatemachineTest() {

		StateMachine sm = new StateMachine();
		
		sm.addState(new State("StartState", "This is the Start State of the Machine" ));		

		smRepo.save(sm);
		
	}
	
	
	
	@Test
	void createStatemachineAndSetStartStateTest() {
		
		StateMachine sm = new StateMachine();
		State startState = new State("StartState", "This is the Start State of the machine");

		sm.addState(startState);
		
		sm.setStartState(startState);
		
		smRepo.save(sm);
		
		assertThat(sm.getStartState().getId()).isEqualTo(startState.getId());
		
	}
	
	@Test
	void AddTransitionToStatemachineTest() {
		
		StateMachine sm = new StateMachine();
		State startState = new State("StartState", "This is the Start State of the machine");
		State finalState = new State("FinalState", "This is the End State of the machine");

		sm.addState(startState);
		sm.addState(finalState);
		
		sm.setStartState(startState);
				
		try {
			sm.addStateTransition(new StateTransition(startState, finalState));
		} catch (StateisNotMemberOfMachineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		smRepo.save(sm);
		
		assertThat(sm.getStartState().getId()).isEqualTo(startState.getId());
		
	}

	@Test
	void whenStateinTransitionIsNotContainedInMachineThrowStateIsNotMemberException() {
		
		StateMachine sm = new StateMachine();
		State startState = new State("StartState", "This is the Start State of the machine");
		State notContainedState = new State("NotContainedState", "This is state is not in Machine");
		sm.addState(startState);
						
		
		Assertions.assertThrowsExactly(StateisNotMemberOfMachineException.class, 
								()-> sm.addStateTransition(new StateTransition(startState, notContainedState)));
		smRepo.save(sm);
		
		
	}
	
	
	
	
	
}
