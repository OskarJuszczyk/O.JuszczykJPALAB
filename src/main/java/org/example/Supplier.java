package org.example;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int SupplierId;

    private String CompanyName;
    private String Street;
    private String City;


    @OneToMany
    private Set<Product> products = new LinkedHashSet<>();

    public Supplier(String CompanyName, String Street, String City) {
        this.CompanyName = CompanyName;
        this.Street = Street;
        this.City = City;
    }

    public Supplier() {
    }

    public void addProduct(Product product) {
        products.add(product);
        product.setSupplier(this);
    }

    @Override
    public String toString() {
        return "Supplier{" + "SupplierId=" + SupplierId + ", CompanyName=" + CompanyName + ", Street=" + Street + ", City=" + City + '}';
    }

}
