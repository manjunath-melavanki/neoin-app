package com.neoin.shop.service;

import com.neoin.shop.model.VendorCategoryModel;

import java.util.List;

public interface VendorCategoryService {
    VendorCategoryModel createVendorCategory(VendorCategoryModel vendorCategory);

    List<VendorCategoryModel> getAllVendorCategories();

    VendorCategoryModel findByVendorCategoryId(long id);

    VendorCategoryModel updateVendorCategoryById(VendorCategoryModel vendorCategory, long id);

    List<VendorCategoryModel> getAllActiveVendorCategories();
}
