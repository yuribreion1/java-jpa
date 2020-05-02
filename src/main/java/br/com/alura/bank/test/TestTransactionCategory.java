package br.com.alura.bank.test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.bank.models.Account;
import br.com.alura.bank.models.Category;
import br.com.alura.bank.models.Transaction;
import br.com.alura.bank.models.TransactionType;

public class TestTransactionCategory {
    public static void main(String[] args) {
        Category category1 = new Category("Travels");
        Category category2 = new Category("Meetings");

        Account account = new Account();
        account.setId(2L);

        Transaction transaction = new Transaction();
        transaction.setDescription("Travel to São Paulo");
        transaction.setType(TransactionType.OUTBOUND);
        transaction.setCurrentDate(LocalDateTime.now());
        transaction.setValue(new BigDecimal(300.00));
        transaction.setCategories(Arrays.asList(category1, category2));
        transaction.setAccount(account);

        Transaction transaction2 = new Transaction();
        transaction2.setDescription("Travel to Tallin");
        transaction2.setType(TransactionType.OUTBOUND);
        transaction2.setCurrentDate(LocalDateTime.now());
        transaction2.setValue(new BigDecimal(2500.00));
        transaction2.setCategories(Arrays.asList(category1, category2));
        transaction2.setAccount(account);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(category1);
        em.persist(category2);
        em.persist(transaction);
        em.persist(transaction2);
        em.getTransaction().commit();
        em.close();

    }
}