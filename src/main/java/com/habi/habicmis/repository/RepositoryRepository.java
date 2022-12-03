package com.habi.habicmis.repository;


import org.springframework.data.repository.CrudRepository;
import com.habi.habicmis.model.Repository;


public interface RepositoryRepository extends CrudRepository<Repository, Long> {

		public com.habi.habicmis.model.Repository findByName(String name);
}
