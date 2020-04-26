package br.com.alura.bank.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.bank.models.Account;

public class ClassStates {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
		EntityManager em = emf.createEntityManager();
		
//		Java Bean
		Account account = new Account();
		account.setAccountNumber(995);
		account.setAccountOwner("Marcia Cristina");
		account.setBranch(1298);
		account.setAmount(2500);
		
//		JPA transaction
		em.getTransaction().begin();
		em.persist(account);
		em.getTransaction().commit();
		em.close();
		
//		At this time this new amount value won't update the model because the transaction was closed above
		account.setAmount(5000);
		
//		The merge method able us to turn this state managed again and persist to database
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();
		em1.merge(account);
		em1.getTransaction().commit();
		
	}
}
