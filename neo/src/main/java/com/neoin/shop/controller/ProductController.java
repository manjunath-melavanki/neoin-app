package com.neoin.shop.controller;

import com.neoin.shop.model.ProductFilter;
import com.neoin.shop.model.ProductModel;
import com.neoin.shop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/getAll")
    public @ResponseBody
    ResponseEntity<List<ProductModel>> getProducts(@RequestBody ProductFilter productFilter) {
        log.info("Product Filter : {}", productFilter);
        return new ResponseEntity<List<ProductModel>>(productService.getProducts(productFilter), HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody
    ResponseEntity<ProductModel> updateProduct(@RequestBody ProductModel productModel) {
        return new ResponseEntity<ProductModel>(productService.updateProduct(productModel), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<ProductModel> createProduct(@RequestBody ProductModel productModel) {
        return new ResponseEntity<ProductModel>(productService.createProduct(productModel), HttpStatus.OK);
    }
}
