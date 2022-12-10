package com.habi.habicmis.model;

import java.util.Set;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;

@Entity
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
		
	@ManyToMany(mappedBy =  "assignedDocuments")	
	Set<BusinessObject> assignedBusinessObjects;
	
}
