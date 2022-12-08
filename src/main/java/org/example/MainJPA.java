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

        Product product = new Product("Ser", 4);
        Product product1 = new Product("Masło vegan", 6);
        Product product2 = new Product("Mleko", 2);
        Product product3 = new Product("Chleb", 1);


        Invoice invoice = new Invoice(2);
        Invoice invoice1 = new Invoice(3);

        // INVOICE

        invoice.addProduct(product);
        product.addInvoice(invoice);

        invoice.addProduct(product1);
        product1.addInvoice(invoice);

        invoice.addProduct(product2);
        product2.addInvoice(invoice);

        invoice.addProduct(product3);
        product3.addInvoice(invoice);

        // INVOICE 1

        invoice1.addProduct(product);
        product.addInvoice(invoice1);

        invoice1.addProduct(product1);
        product1.addInvoice(invoice1);


        em.persist(product);
        em.persist(product1);
        em.persist(product2);
        em.persist(product3);
        em.persist(invoice);
        em.persist(invoice1);

        etx.commit();
        em.close();
    }
}