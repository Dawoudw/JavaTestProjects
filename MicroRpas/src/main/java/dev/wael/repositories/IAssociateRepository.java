package dev.wael.repositories;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;

import dev.wael.entities.Associate;

@SpringBootApplication
public interface IAssociateRepository extends CrudRepository<Associate, Integer> {
	List<Associate> findByName(String name);

	List<Associate> findByPointsBetween(int min, int max);
}
