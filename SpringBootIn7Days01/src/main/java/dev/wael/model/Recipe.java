package dev.wael.model;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name =  "Recipe")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	//@Column(name = "title") // is not required in mem db
	String title;
	//@Column(name = "description") // is not required in mem db
	String description;

	public Recipe(int id, String title, String description) {

		this.id = id;
		this.title = title;
		this.description = description;
	}

	public Recipe() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
}
