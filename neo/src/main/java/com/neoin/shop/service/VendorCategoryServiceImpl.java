package com.neoin.shop.service;

import com.neoin.shop.entity.VendorCategory;
import com.neoin.shop.model.VendorCategoryModel;
import com.neoin.shop.repository.VendorCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendorCategoryServiceImpl implements VendorCategoryService {
    @Autowired
    private VendorCategoryRepository categoryRepository;

    @Override
    public VendorCategoryModel createVendorCategory(VendorCategoryModel categoryRequest) {
        VendorCategory category = new VendorCategory();
        category.setCategoryName(categoryRequest.getCategoryName());
        category.setStatus(categoryRequest.isStatus());
        category.setPriority(categoryRequest.getPriority());
        category.setCreatedBy("Test User");
        category.setCreatedAt(System.currentTimeMillis());
        return mapToResponse(categoryRepository.save(category));
    }

    @Override
    public List<VendorCategoryModel> getAllVendorCategories() {
        return categoryRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public VendorCategoryModel findByVendorCategoryId(long id) {
        return mapToResponse(categoryRepository.findById(id).get());
    }

    @Override
    public VendorCategoryModel updateVendorCategoryById(VendorCategoryModel vendorCategory, long id) {
        Optional<VendorCategory> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            VendorCategory cat = category.get();
            cat.setCategoryName(vendorCategory.getCategoryName());
            cat.setPriority(vendorCategory.getPriority());
            cat.setStatus(vendorCategory.isStatus());
            cat.setModifiedAt(System.currentTimeMillis());
            cat.setModifiedBy("Test User");
            return mapToResponse(categoryRepository.save(cat));
        }
        return null;
    }

    @Override
    public List<VendorCategoryModel> getAllActiveVendorCategories() {
        return categoryRepository.getAllActiveVendorCategories().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    private VendorCategoryModel mapToResponse(VendorCategory output) {
        return VendorCategoryModel.builder()
                .id(output.getId())
                .categoryName(output.getCategoryName())
                .Status(output.getStatus())
                .priority(output.getPriority())
                .build();
    }
}
