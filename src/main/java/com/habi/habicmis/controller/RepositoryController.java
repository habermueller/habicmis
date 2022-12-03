package com.habi.habicmis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habi.habicmis.model.Repository;
import com.habi.habicmis.repository.RepositoryRepository;

@RestController
@RequestMapping("/repository")
public class RepositoryController {

	Logger log = LoggerFactory.getLogger(RepositoryController.class); 
	
	private RepositoryRepository repositoryRepository; 
	
	public RepositoryController(RepositoryRepository repRepository) {
		this.repositoryRepository = repRepository;
	}
	
	@PostMapping
	ResponseEntity<Repository> createRepository(@RequestBody Repository repo){
		log.info("Start Creating a new Repository");
		log.info(repo.toString());
		
		repositoryRepository.findByName(repo.getName()); 
		if (repositoryRepository.findByName(repo.getName()) != null) {
			return new ResponseEntity<>(repo, HttpStatus.ALREADY_REPORTED);
		}
		
		repositoryRepository.save(repo);
						
		return new ResponseEntity<>(repo, HttpStatus.CREATED);		
	}
	
	@GetMapping	
	ResponseEntity<Iterable<Repository>> getRepositories(){
		return new ResponseEntity<>(repositoryRepository.findAll(), HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
}
