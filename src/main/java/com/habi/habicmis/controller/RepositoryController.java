package com.habi.habicmis.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habi.habicmis.model.Repository;
import com.habi.habicmis.repository.RepositoryRepository;



import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

//tag::hateoas-imports[]
//end::hateoas-imports[]



@RestController
//@RequestMapping("/repository")
public class RepositoryController {

	Logger log = LoggerFactory.getLogger(RepositoryController.class); 
	
	private RepositoryRepository repositoryRepository;
	private RepositoryModelAssembler repModelAssembler;
	
	public RepositoryController(RepositoryRepository repRepository, RepositoryModelAssembler repModelAssembler) {
		this.repositoryRepository = repRepository;
		this.repModelAssembler= repModelAssembler;
	}
	
	@PostMapping("/repository")
	EntityModel<Repository> createRepository(@RequestBody Repository repo){
		log.info("Start Creating a new Repository");
		log.info(repo.toString());
				
		 
		if (repositoryRepository.findByName(repo.getName()) != null) {
			throw new RepositoryExistsException(repo.getName());
		}
		
		repositoryRepository.save(repo);
						
		return repModelAssembler.toModel(repo);		
	}
	
	@GetMapping("/repository")	
	CollectionModel<EntityModel<Repository>> getRepositories(){
		log.info("GetAllRepository Service Requested");

		List<EntityModel<Repository>> repositories = repositoryRepository.findAll().stream()
				.map(repModelAssembler::toModel)						
				.collect(Collectors.toList());					
		return CollectionModel.of(repositories, linkTo(methodOn(RepositoryController.class).getRepositories()).withSelfRel());		
				
	}
	
	@GetMapping("/repository/{name}")
	EntityModel<Repository> getRepositoryByName(@PathVariable String name){
		log.info("Get Repository By Name Service Requested for repo " + name);
				
		Repository repo = repositoryRepository.findByName(name);		
		if (repo == null) {
			throw new RepositoryNotFoundException(name);
		}
		
		return repModelAssembler.toModel(repo);
	}
	
	@PutMapping("/repository/{name}")
	EntityModel<Repository>  putRepositorybyName(@RequestBody Repository newRepo,  @PathVariable String name){
		log.info("Put Repository By Name Service Requested for repo " + name);
		
		Repository repo = repositoryRepository.findByName(name);		
		if (repo == null) {
			throw new RepositoryNotFoundException(name);
		}
		
		repo.setName(newRepo.getName());
		//To do: here something more intelligent.
				
		repositoryRepository.save(repo);
		
		return repModelAssembler.toModel(repo);
		
		
	}
	
	
	
	
	
	
}
