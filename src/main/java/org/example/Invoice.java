package org.example;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int InvoiceId;

    private int Quantity;


    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Product> products = new LinkedHashSet<>();


    public Set<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Invoice(int quantity) {
        Quantity = quantity;
    }

    public Invoice() {
    }
}
