package ru.bul.spr.TestForLab.dto;

import jakarta.persistence.*;
import ru.bul.spr.TestForLab.models.Product;

import java.util.List;

public class CountryDTO {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
