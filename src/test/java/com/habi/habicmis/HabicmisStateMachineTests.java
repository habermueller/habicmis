package com.habi.habicmis;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.habi.habicmis.model.State;
import com.habi.habicmis.model.StateMachine;
import com.habi.habicmis.repository.StateMachineRepository;
import com.habi.habicmis.repository.StateRepository;


@SpringBootTest
//@DataJpaTest
public class HabicmisStateMachineTests {

	@Autowired
	StateMachineRepository smRepo;
	
	@Autowired
	StateRepository stateRepo;
	
	@Test
	void createStatemachineTest() {
		
			
		StateMachine sm = new StateMachine();
		
		sm.addState(new State("StartState", "This is the Start State of the Machine" ));
		
		smRepo.save(sm);
		
		assertThat(sm.getId()).isGreaterThan(0);
		
		
		
		
	}
	
	
	
}
