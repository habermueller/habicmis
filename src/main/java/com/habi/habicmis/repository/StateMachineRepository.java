package com.habi.habicmis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.habi.habicmis.model.StateMachine;

public interface StateMachineRepository extends JpaRepository<StateMachine, Long>{

}
