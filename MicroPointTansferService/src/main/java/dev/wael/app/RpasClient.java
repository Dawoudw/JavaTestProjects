package dev.wael.app;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.wael.entities.Associate;

@Component
@FeignClient("Associate-Service") // the name of the service on Eurika saved in yaml file
public interface RpasClient {
//local host 9111
	@RequestMapping(value = "/associates", method = RequestMethod.GET)
	List<Associate> getAllAssociates();

	@RequestMapping(value = "/associates/{id}", method = RequestMethod.GET)
	Associate getAllAssociatesByID(@PathVariable Integer id);

}
