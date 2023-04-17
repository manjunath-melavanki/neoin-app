package com.neoin.shop.service;

import com.neoin.shop.model.ProductFilter;
import com.neoin.shop.model.ProductModel;

import java.util.List;

public interface ProductService {
    ProductModel createProduct(ProductModel productModel);

    ProductModel updateProduct(ProductModel productModel);

    List<ProductModel> getProducts(ProductFilter productFilter);
}
