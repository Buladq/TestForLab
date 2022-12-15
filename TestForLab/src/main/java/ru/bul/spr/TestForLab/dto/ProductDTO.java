package ru.bul.spr.TestForLab.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import ru.bul.spr.TestForLab.models.Category;
import ru.bul.spr.TestForLab.models.Country;
import ru.bul.spr.TestForLab.models.Discount;
import ru.bul.spr.TestForLab.models.Gift;

public class ProductDTO {

    private String title;


    private int price;

    private CategoryDTO category;


    private CountryDTO country;


    private DiscountDTO discount;

    private GiftDTO gift;//какой подарок в комплекте

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

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public DiscountDTO getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountDTO discount) {
        this.discount = discount;
    }

    public GiftDTO getGift() {
        return gift;
    }

    public void setGift(GiftDTO gift) {
        this.gift = gift;
    }
}