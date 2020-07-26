package dev.wael.app;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.wael.entities.Associate;
import dev.wael.repositories.IAssociateRepository;

@SpringBootTest
@Transactional
public class RevPasApplicationTest {

	@Autowired
	IAssociateRepository ar;

	@Test
	@Rollback
	void addnew() {

		Associate as = new Associate(0, "test", 15000);
		ar.save(as);

	}

	@Test
	void between() {
		Iterable<Associate> lst = ar.findByPointsBetween(1520, 1600) ;
		Set<Associate> st = new HashSet<Associate>((Collection<? extends Associate>) lst);

		System.out.println(st);

	}

	@Test
	void test() {
		Iterable<Associate> lst = ar.findAll();
		Set<Associate> st = new HashSet<Associate>((Collection<? extends Associate>) lst);

		System.out.println(st);

	}
}
