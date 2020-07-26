package dev.wael.app;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import dev.wael.entities.Associate;
import dev.wael.repositories.IAssociateRepository;

@SpringBootTest
@ContextConfiguration(classes = dev.wael.app.App.class)
public class AssocaiteTest {

	@Autowired
	IAssociateRepository ar;

	public AssocaiteTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	@Order(1)
	public void createAssocaite() {
		Associate as = new Associate(0, "test2", 100);
		// ar.save(as);
	}

	@Test
	@Order(2)
	public void udateAssocaite() {
		List<Associate> as = ar.findByName("test");
		System.out.println(as);
	}
}
