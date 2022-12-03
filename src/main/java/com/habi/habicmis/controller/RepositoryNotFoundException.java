package com.habi.habicmis.controller;

@SuppressWarnings("serial")
public class RepositoryNotFoundException extends RuntimeException{
	
	public RepositoryNotFoundException(String repo) {
		
		super("Repository with name <" + repo + "> already exists" );
	}
	

}
