package dev.wael.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.wael.app.RpasClient;
import dev.wael.entities.Associate;
import dev.wael.services.EnrollemntService;

@Controller
@Component
@RestController
@CrossOrigin("*") // public for any one to use
public class EnrollmentController {

	public EnrollmentController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	RpasClient rpas;
	@Autowired
	EnrollemntService pts;

	@RequestMapping(value = "/enroll/{email}", method = RequestMethod.POST)
	@ResponseBody
	public Associate CreateAssociate(@RequestBody Associate associate, @PathVariable String email) {
		return pts.CreateAssociate(associate, email);
	}

}
