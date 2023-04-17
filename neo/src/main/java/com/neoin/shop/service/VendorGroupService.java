package com.neoin.shop.service;

import com.neoin.shop.model.VendorGroupModel;

import java.util.List;

public interface VendorGroupService {
    VendorGroupModel updateVendorGroupById(VendorGroupModel groupModel, long id);

    VendorGroupModel findByVendorGroupId(long id);

    List<VendorGroupModel> getAllVendorGroups();

    List<VendorGroupModel> getAllActiveVendorGroups();

    VendorGroupModel createVendorGroup(VendorGroupModel groupModel);
}
