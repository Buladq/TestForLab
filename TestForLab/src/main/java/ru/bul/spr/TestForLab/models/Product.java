package ru.bul.spr.TestForLab.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;


    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "category",referencedColumnName = "id")
    private Category category;


    @ManyToOne
    @JoinColumn(name = "country",referencedColumnName = "id")
    private Country country; //страна в которой был произведен товар

    @ManyToOne
    @JoinColumn(name = "discount")
    private Discount discount;


    @ManyToOne
    @JoinColumn(name = "gift")
    private Gift gift;//какой подарок в комплекте


    public Product(String title, int price, Category category, Country country, Discount discount, Gift gift) {
        this.title = title;
        this.price = price;
        this.category = category;
        this.country = country;
        this.discount = discount;
        this.gift = gift;
    }

    public Product() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Gift getGift() {
        return gift;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }
}
