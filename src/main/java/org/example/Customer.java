package org.example;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Customer extends Company implements Serializable {

    private int Discount;

    public Customer(String companyName, String street, String city, String zipCode, int discount) {
        super(companyName, street, city, zipCode);
        Discount = discount;
    }

    public Customer() {
        super();
    }
}
