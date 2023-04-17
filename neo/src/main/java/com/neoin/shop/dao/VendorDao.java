package com.neoin.shop.dao;

import com.neoin.shop.model.VendorFilter;
import com.neoin.shop.model.VendorModel;

import java.util.List;

public interface VendorDao {
    List<VendorModel> findAll(VendorFilter vendorFilter);
}
