package dev.wael.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.wael.model.Recipe;
import dev.wael.service.RecipeService;

@RestController
@CrossOrigin("*")
public class RecipeContoller {

	public RecipeContoller() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	RecipeService srv;

	@GetMapping(value = "/recipe")
 
	public List<Recipe> getAllRecipes() {
		return srv.getAll();
	}

	@PostMapping(value = "/recipe")
	public Recipe AddRecipe(@RequestBody Recipe rec) {
		return srv.Add(rec);
	}
}
