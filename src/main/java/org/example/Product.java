package org.example;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ProductId;

    private String ProductName;
    private int UnitsOnStock;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private Set<Invoice> invoices = new LinkedHashSet<>();

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public Product(String ProductName, int UnitsOnStock) {
        this.ProductName = ProductName;
        this.UnitsOnStock = UnitsOnStock;
    }

    public Product() {

    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductId=" + ProductId +
                ", ProductName='" + ProductName + '\'' +
                ", UnitsOnStock=" + UnitsOnStock +
                '}';
    }
}


