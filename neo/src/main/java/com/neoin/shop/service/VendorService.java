package com.neoin.shop.service;

import com.neoin.shop.model.VendorFilter;
import com.neoin.shop.model.VendorModel;

import java.util.List;

public interface VendorService {
    VendorModel createVendor(VendorModel vendorModel);

    VendorModel updateVendor(VendorModel vendorModel);

    List<VendorModel> getVendor(VendorFilter vendorFilter);
}
