package org.example;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Supplier extends Company implements Serializable {
    private String BankAccountNumber;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<Product> products = new LinkedHashSet<>();

    public Supplier(String companyName, String street, String city, String zipCode, String bankAccountNumber) {
        super(companyName, street, city, zipCode);
        BankAccountNumber = bankAccountNumber;
    }

    public Supplier() {
        super();
    }

    public void addProduct(Product product) {
        products.add(product);
        product.setSupplier(this);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "BankAccountNumber='" + BankAccountNumber + '\'' +
                ", products=" + products +
                '}';
    }
}
