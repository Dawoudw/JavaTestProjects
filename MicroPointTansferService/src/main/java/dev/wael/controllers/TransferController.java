package dev.wael.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

import dev.wael.app.RpasClient;
import dev.wael.entities.Associate;
import dev.wael.services.PointTransferService;

@Controller
@Component
@RestController
@CrossOrigin("*") // public for any one to use
public class TransferController {

	public TransferController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	RpasClient rpas;
	@Autowired
	PointTransferService pts;

	@RequestMapping(value = "/allassociates", method = RequestMethod.GET)
	@ResponseBody
	public List<Associate> getAllAssociates() {
		return rpas.getAllAssociates();
	}

	int counter = 0;

	@HystrixCommand(fallbackMethod = "transferBackup")
	@RequestMapping(value = "/transfer/senderid/{senderid}/recipientid/{recipientid}/amount/{amount}", method = RequestMethod.GET)
	public String transferPoint(@PathVariable Integer senderid, @PathVariable Integer recipientid,
			@PathVariable Integer amount) {
		pts.transferpoint(senderid, recipientid, amount);

		counter++;
		if (counter % 5 == 0) {
			throw new RuntimeException();
		}

		return "Success";

	}

	public String transferBackup(Integer sid, Integer rid, Integer am) {
		System.out.println("Transfer couldn't be done sender " + sid + " Reciver" + rid +" Your Tansfer has been logged ");
		return "Transfer couldn't be done , Your Tansfer has been logged ";
	}
}
