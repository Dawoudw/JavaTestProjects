package dev.wael.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
 

import dev.wael.app.RpasClient;
import dev.wael.entities.Associate;
@Component
@Service
public class EnrollemntServiceImpl implements EnrollemntService {

	public EnrollemntServiceImpl() {
		// TODO Auto-generated constructor stub

	}

	@Autowired
	RpasClient rpas;
	
	@Autowired 
	JavaMailSender mailer;

	@Override
	public Associate CreateAssociate(Associate associate , String email) {
		// TODO Auto-generated method stub
		Associate aso =rpas.CreateAssociate(associate);
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);
		msg.setSubject("Assoiciate Enrollment") ;
		msg.setText("Your Registration ID is "+aso.getaId()) ;
		mailer.send(msg);
		return  aso;
	}

 
}
