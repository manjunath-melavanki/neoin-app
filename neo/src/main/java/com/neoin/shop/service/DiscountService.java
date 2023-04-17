package com.neoin.shop.service;

import com.neoin.shop.model.DiscountFilter;
import com.neoin.shop.model.DiscountModel;

import java.util.List;

public interface DiscountService {
    DiscountModel createDiscount(DiscountModel discountModel);

    DiscountModel updateDiscount(DiscountModel discountModel);

    List<DiscountModel> getDiscount(DiscountFilter discountFilter);
}
