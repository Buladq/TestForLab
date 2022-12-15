package ru.bul.spr.TestForLab.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bul.spr.TestForLab.models.Country;
import ru.bul.spr.TestForLab.models.Product;
import ru.bul.spr.TestForLab.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> allProduct(String select) {
        if(select==null){
            return productRepository.findAll();
        }

         else if (select.equals("1")) {
                return productRepository.findAll().stream()
                        .filter(p -> p.getCountry().getName().equals("Россия")).collect(Collectors.toList());
         }
          else if (select.equals("2")) {
                return productRepository.findAll().stream()
                        .filter(p -> p.getGift() != null).collect(Collectors.toList());
          }

        else if (select.equals("3")) {
            return productRepository.findAll().stream()
                    .filter(p -> p.getDiscount()!=null).collect(Collectors.toList());
        }
        else if (select.equals("4")) {
            return productRepository.findAll().stream()
                    .filter(p -> !Objects.equals(p.getCountry().getName(), "Россия")).collect(Collectors.toList());
        }
        else if (select.equals("5")) {
            return productRepository.findAll(Sort.by(Sort.Direction.ASC,"price"));
        }
          else {
            return Collections.emptyList();
        }

    }




    public List<Product> findByTitle(String title){
        return productRepository.findBytitle(title);
    }






}
