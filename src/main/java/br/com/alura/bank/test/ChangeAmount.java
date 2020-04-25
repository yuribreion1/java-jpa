package br.com.alura.bank.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.bank.models.Account;

public class ChangeAmount {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
		EntityManager em = emf.createEntityManager();
		
		Account accountWithoutAmount = em.find(Account.class, 1L);
		em.getTransaction().begin();
		accountWithoutAmount.setAccountOwner("Edmilson Breion");
		em.getTransaction().commit();
	}

}
