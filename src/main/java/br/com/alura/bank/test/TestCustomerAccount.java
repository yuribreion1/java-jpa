package br.com.alura.bank.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.bank.models.Account;
import br.com.alura.bank.models.Customer;

public class TestCustomerAccount {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
        EntityManager em = emf.createEntityManager();
        
        Account account = new Account();
        account.setId(1L);

        Customer customer = new Customer();
        customer.setName("Ricardo Oliveira");
        customer.setAddress("Augusta, 3500");
        customer.setRole("Risk Analyst");
        em.getTransaction().begin();
        em.persist(customer);
        em.getTransaction().commit();
        em.close();

    }
}