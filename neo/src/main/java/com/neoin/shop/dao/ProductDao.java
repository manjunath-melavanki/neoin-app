package com.neoin.shop.dao;

import com.neoin.shop.entity.Product;
import com.neoin.shop.model.ProductFilter;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts(ProductFilter productFilter);
}
