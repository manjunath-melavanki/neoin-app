package com.neoin.shop.dao;

import com.neoin.shop.entity.Discount;
import com.neoin.shop.model.DiscountFilter;

import java.util.List;

public interface DiscountDao {
    List<Discount> getDiscount(DiscountFilter discountFilter);
}
