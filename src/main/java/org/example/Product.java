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


    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Category category;

    public Product(String ProductName, int UnitsOnStock, Supplier supplier, Category category) {
        this.ProductName = ProductName;
        this.UnitsOnStock = UnitsOnStock;
        this.supplier = supplier;
        this.category = category;
    }

    public Product() {

    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public void setCategory(Category category) {
        this.category = category;

    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductId=" + ProductId +
                ", ProductName='" + ProductName + '\'' +
                ", UnitsOnStock=" + UnitsOnStock +
                ", supplier=" + supplier +
                ", category=" + category +
                '}';
    }
}


