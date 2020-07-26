package dev.wael.repositories;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import dev.wael.entities.Associate;
 
@RepositoryRestResource
public interface IAssociateRepository extends CrudRepository<Associate, Integer> {
	List<Associate> findByName(String name);

	List<Associate> findByPointsBetween(int min, int max);
}
