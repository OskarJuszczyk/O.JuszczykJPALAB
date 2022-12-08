package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainJPA {
    public static void main(final String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();

        Supplier supplier = new Supplier("Mlekowita", "Kwiatowa", "Warszawa", "00-000", "1234567890");
        Customer customer = new Customer("Kowalscy", "Kwiatowa", "Warszawa", "00-000", 10);

        em.persist(supplier);
        em.persist(customer);

        etx.commit();
        em.close();
    }
}