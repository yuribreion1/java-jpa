package br.com.alura.bank.test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.bank.models.Account;
import br.com.alura.bank.models.Transaction;
import br.com.alura.bank.models.TransactionType;

public class TestTransaction {

	public static void main(String[] args) {
		
		Account account = new Account();
		
		account.setAccountNumber(775);
		account.setAccountOwner("Valeria Dias");
		account.setAmount(300.00);
		account.setBranch(0550);
		
		
		Transaction transaction = new Transaction();
		
		transaction.setCurrentDate(LocalDateTime.now());
		transaction.setValue(new BigDecimal(200.0));
		transaction.setType(TransactionType.INBOUND);
		transaction.setDescription("Bill");
		transaction.setAccount(account);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(account);
		em.persist(transaction);
		em.getTransaction().commit();
		em.close();

	}

}
