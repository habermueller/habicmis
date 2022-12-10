package com.habi.habicmis.model;

import java.util.Set;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class BusinessObject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToMany
	@JoinTable(
				name = "documents_assigned",
				joinColumns = @JoinColumn(name = "bo_id"),
				inverseJoinColumns = @JoinColumn(name= "doc_id")
				)
				
	Set<Document> assignedDocuments; 
	
}
