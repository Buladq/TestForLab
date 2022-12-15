package ru.bul.spr.TestForLab.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "discount")
public class Discount {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "percent")
    private int percent;

    @OneToMany(mappedBy = "discount")
    private List<Product> productList;

    public Discount() {
    }

    public Discount(int percent, List<Product> productList) {
        this.percent = percent;
        this.productList = productList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int sum) {
        this.percent = sum;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
