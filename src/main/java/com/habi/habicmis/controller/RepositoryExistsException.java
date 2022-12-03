package com.habi.habicmis.controller;

@SuppressWarnings("serial")
public class RepositoryExistsException extends RuntimeException{
	
	public RepositoryExistsException(String repo) {
		
		super("Repository with name <" + repo + ">not found" );
	}
	

}
