package dev.wael.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.wael.model.Recipe;

@Repository
public interface IRecipeRepository extends JpaRepository<Recipe, Integer> {
	

}
