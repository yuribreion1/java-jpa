package br.com.alura.bank.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.bank.models.Account;

public class TestCreateAccount {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bank"); 
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
//		Transaction beggin
		entityManager.getTransaction().begin();
		
//		New object
		Account account = new Account();
		account.setAccountNumber(10052);
		account.setAccountOwner("Anna Lippi");
		account.setBranch(1233);
		account.setAmount(1500);
		
		entityManager.persist(account);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}
