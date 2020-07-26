package dev.wael.service;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.wael.dao.IRecipeRepository;
import dev.wael.model.Recipe;

@Service
public class RecipeService {

	public RecipeService() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	IRecipeRepository rep;

	public Recipe Add(Recipe rec) {
		return rep.save(rec);
	}

	public List<Recipe> getAll() {
		return rep.findAll();

	}
}
