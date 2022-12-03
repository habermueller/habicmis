package com.habi.habicmis.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.habi.habicmis.model.Repository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@Component
public class RepositoryModelAssembler implements RepresentationModelAssembler<Repository, EntityModel<Repository>> {

	@Override
	public EntityModel<Repository> toModel(Repository repository) {
		
		return EntityModel.of(repository,
								linkTo(methodOn(RepositoryController.class).getRepositoryByName(repository.getName())).withSelfRel(),
								linkTo(methodOn(RepositoryController.class).getRepositories()).withRel("repository")
								);
		
	}

}
