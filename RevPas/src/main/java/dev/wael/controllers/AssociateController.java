package dev.wael.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.server.ResponseStatusException;

import dev.wael.aspects.Authorized;
import dev.wael.entities.Associate;
import dev.wael.services.IAssociateService;

@Component
@Controller
@CrossOrigin("*") // public for any one to use
public class AssociateController {
	@Autowired
	IAssociateService as;

	public AssociateController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/associates", method = RequestMethod.GET)
	@ResponseBody
	public List<Associate> getAllAssociates() {
		return as.getAllAssociates();
	}

	@RequestMapping(value = "/associates/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Associate getAssociateById(@PathVariable int id) {

		try {
			return as.getAssociateById(id);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id is not found");
		}
	}

	@ResponseBody
	@RequestMapping(value = "/associates", method = RequestMethod.POST)
	public Associate createAssociate(@RequestBody Associate associate) {

		System.out.println(associate);
		return as.createAssociate(associate);

	}

	@ResponseBody
	@RequestMapping(value = "/associates", method = RequestMethod.PUT)
	@Authorized
	public Associate updateAssociate(@RequestBody Associate associate) {

		System.out.println(associate);
		return as.updateAssociate(associate);

	}

	@ResponseBody
	@RequestMapping(value = "/associates", method = RequestMethod.DELETE)
	@Authorized
	public void deleteAssociate(@RequestBody Associate associate) {

		System.out.println(associate);
		boolean reslut = as.deleteAssociate(associate);
		if (!reslut)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Delete failed");

	}

	@ResponseBody
	@RequestMapping(value = "/query/associates", method = RequestMethod.GET)
	public List<Associate> getAssociatesByPointRange(@RequestParam int min, @RequestParam(required = false) Integer max) {

		return as.getAllAssociatesbyRange(min, max);

	}

}
