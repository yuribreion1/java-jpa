package br.com.alura.bank.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestTableAccount {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bank");
//		EntityManager createEntityManager = emf.createEntityManager();
		emf.close();
	}
}
