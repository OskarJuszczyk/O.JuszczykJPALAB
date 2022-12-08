package org.example;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CompanyId;

    private String CompanyName;
    private String Street;
    private String City;
    private String ZipCode;

    public Company(String companyName, String street, String city, String zipCode) {
        CompanyName = companyName;
        Street = street;
        City = city;
        ZipCode = zipCode;
    }

    public Company() {
    }
}
