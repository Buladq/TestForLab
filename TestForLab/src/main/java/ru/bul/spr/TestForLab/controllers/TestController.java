package ru.bul.spr.TestForLab.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.bul.spr.TestForLab.dto.ProductDTO;
import ru.bul.spr.TestForLab.models.Product;
import ru.bul.spr.TestForLab.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TestController {
    private final ProductService productService;

    private final ModelMapper modelMapper;



    @Autowired
    public TestController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;

        this.modelMapper = modelMapper;
    }

    //все значения,1-товары сделанные в рф,2-товары с подарком,3-товары со скидкой,
    //4-зарубежные товары,5-сортировка товара по возр
    @GetMapping("/products")
    public List<ProductDTO> getProducts(@RequestParam(value = "selection",required = false)String selection){
        return productService.allProduct(selection).stream().map(this::convertToProductDTO)
                .collect(Collectors.toList());
    }

    //поиск товара по названию
    @GetMapping("/find")
    public List<ProductDTO> getProductByTitle(@RequestParam(value = "title",required = false) String title){
        return productService.findByTitle(title).stream().map(this::convertToProductDTO)
                .collect(Collectors.toList());
    }


    private ProductDTO convertToProductDTO(Product product) {
        return modelMapper.map(product,ProductDTO.class);
    }

}
