package dev.wael.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.wael.entities.Associate;
import dev.wael.repositories.IAssociateRepository;

@Component
@Service
public class AssociateService implements IAssociateService {

	@Autowired
	IAssociateRepository ar;

	public AssociateService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Associate createAssociate(Associate as) {
		// TODO Auto-generated method stub
		return ar.save(as);
	}

	@Override
	public Associate getAssociateById(int id) {
		// TODO Auto-generated method stub
		return ar.findById(id).get();
	}

	@Override
	public Associate updateAssociate(Associate as) {
		// TODO Auto-generated method stub
		return ar.save(as);
	}

	@Override
	public boolean deleteAssociate(Associate as) {
		// TODO Auto-generated method stub
		ar.delete(as);
		return true;
	}

	@Override
	public List<Associate> getAllAssociates() {
		// TODO Auto-generated method stub
		return (List<Associate>) ar.findAll();
	}

	@Override
	public List<Associate> getAllAssociatesbyRange(int min, int max) {
		// TODO Auto-generated method stub
		return (List<Associate>) ar.findByPointsBetween(min, max);
	}

}
