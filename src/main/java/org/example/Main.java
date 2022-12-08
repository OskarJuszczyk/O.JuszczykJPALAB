package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
//            Supplier supplier = new Supplier("Mlekowita", "Kwiatowa", "Warszawa");
//            Category category = new Category("Nabiał");
//            Category category1 = new Category("Vegan");
//            Product product = new Product("Ser", 4, supplier, category);
//            Product product1 = new Product("Masło vegan", 6, supplier, category1);
//
//            supplier.addProduct(product);
//            supplier.addProduct(product1);
//            category.addProduct(product);
//            category1.addProduct(product1);
//            session.save(supplier);
//            session.save(category);
//            session.save(category1);
//            session.save(product);
//            session.save(product1);
//
//            tx.commit();

            Category category = session.get(Category.class, 116);
            System.out.println(category.getProducts());
        } finally {
            session.close();
        }
    }
}