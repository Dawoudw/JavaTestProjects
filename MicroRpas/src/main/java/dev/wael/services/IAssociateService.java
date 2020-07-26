package dev.wael.services;

import java.util.List;

import dev.wael.entities.Associate;

public interface IAssociateService {

	Associate createAssociate(Associate as);

	Associate getAssociateById(int id);

	Associate updateAssociate(Associate as);

	boolean deleteAssociate(Associate as);

	List<Associate> getAllAssociates();

	List<Associate> getAllAssociatesbyRange(int min, int max);

}
