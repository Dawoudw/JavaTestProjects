package dev.wael.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import dev.wael.app.RpasClient;
import dev.wael.entities.Associate;
@Component
@Service
public class PonitTransferServiceImpl implements PointTransferService {

	public PonitTransferServiceImpl() {
		// TODO Auto-generated constructor stub

	}

	@Autowired
	RpasClient rpas;

	@Override
	public boolean transferpoint(Integer senderId, Integer recipientId, Integer amount) {
		// TODO Auto-generated method stub

		Associate sender = rpas.getAllAssociatesByID(senderId);
		Associate reciver = rpas.getAllAssociatesByID(recipientId);
		sender.setPoint(sender.getPoint() - amount);
		reciver.setPoint(reciver.getPoint() + amount);
		return true;
	}

}
