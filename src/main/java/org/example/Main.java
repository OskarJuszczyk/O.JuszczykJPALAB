package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();

        try {
//            Transaction tx = session.beginTransaction();
//            Product product = new Product("Ser", 4);
//            Product product1 = new Product("Masło vegan", 6);
//            Product product2 = new Product("Mleko", 2);
//            Product product3 = new Product("Chleb", 1);
//
//
//            Invoice invoice = new Invoice(2);
//            Invoice invoice1 = new Invoice(3);
//
//            // INVOICE
//
//            invoice.addProduct(product);
//            product.addInvoice(invoice);
//
//            invoice.addProduct(product1);
//            product1.addInvoice(invoice);
//
//            invoice.addProduct(product2);
//            product2.addInvoice(invoice);
//
//            invoice.addProduct(product3);
//            product3.addInvoice(invoice);
//
//            // INVOICE 1
//
//            invoice1.addProduct(product);
//            product.addInvoice(invoice1);
//
//            invoice1.addProduct(product1);
//            product1.addInvoice(invoice1);
//
//
//            session.save(product);
//            session.save(product1);
//            session.save(product2);
//            session.save(product3);
//            session.save(invoice);
//            session.save(invoice1);
//
//            tx.commit();

            Product product = session.find(Product.class, 125);
            product.getInvoices().forEach(System.out::println);

        } finally {
            session.close();
        }
    }
}