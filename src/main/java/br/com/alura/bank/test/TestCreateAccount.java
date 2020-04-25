package br.com.alura.bank.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.bank.models.Account;

public class TestCreateAccount {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bank"); 
		EntityManager entityManager = entityManagerFactory.createEntityManager(); 
		Account account = new Account();
		account.setAccountNumber(10050);
		account.setAccountOwner("Yuri Breion");
		account.setBranch(1233);
		entityManager.getTransaction().begin();
		entityManager.persist(account);
		entityManager.getTransaction().commit();
	}
}
