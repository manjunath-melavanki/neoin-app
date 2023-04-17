package com.neoin.shop.service;

import com.neoin.shop.dao.DiscountDao;
import com.neoin.shop.entity.Discount;
import com.neoin.shop.model.DiscountCategory;
import com.neoin.shop.model.DiscountFilter;
import com.neoin.shop.model.DiscountModel;
import com.neoin.shop.model.DiscountType;
import com.neoin.shop.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    private DiscountRepository discountRepository;

    @Autowired
    private DiscountDao discountDao;

    @Override
    public DiscountModel createDiscount(DiscountModel discountModel) {
        validateData(discountModel);
        Discount.DiscountBuilder<?, ?> discount = mapToRequest(discountModel);
        discount.createdAt(System.currentTimeMillis())
                .createdBy("Test User");
        return mapToResponse(discountRepository.save(discount.build()));
    }

    @Override
    public DiscountModel updateDiscount(DiscountModel discountModel) {
        validateData(discountModel);
        Optional<Discount> existed = discountRepository.findById(discountModel.getId());
        if (existed.isPresent()) {
            Discount d = existed.get();
            Discount.DiscountBuilder<?, ?> discount = mapToRequest(discountModel);
            Discount toSave = discount.id(d.getId())
                    .createdBy(d.getCreatedBy())
                    .createdAt(d.getCreatedAt())
                    .modifiedAt(System.currentTimeMillis())
                    .modifiedBy("Test User").build();
            return mapToResponse(discountRepository.save(toSave));
        } else {
            throw new RuntimeException("Discount is missing");
        }
    }

    @Override
    public List<DiscountModel> getDiscount(DiscountFilter discountFilter) {
        return discountDao.getDiscount(discountFilter).stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    private Discount.DiscountBuilder<?, ?> mapToRequest(DiscountModel discountModel) {
        return Discount.builder()
                .category(discountModel.getCategory().name())
                .vendorGroupId(discountModel.getVendorGroupId())
                .vendorId(discountModel.getVendorId())
                .productId(discountModel.getProductId())
                .name(discountModel.getName())
                .type(discountModel.getType().name())
                .value(discountModel.getValue())
                .fromDate(discountModel.getFromDate())
                .toDate(discountModel.getToDate())
                .status(discountModel.getStatus());

    }

    private void validateData(DiscountModel discountModel) {
        if (discountModel.getCategory().name().equalsIgnoreCase("VENDOR_GROUP")
                && null == discountModel.getVendorGroupId()) {
            throw new RuntimeException("For group discounts, Kindly provide vendor group Id.");
        } else if (discountModel.getCategory().name().equalsIgnoreCase("VENDOR")
                && null == discountModel.getVendorId()) {
            throw new RuntimeException("For Vendor discounts, Kindly provide vendor Id.");
        } else if (discountModel.getCategory().name().equalsIgnoreCase("PRODUCT")
                && null == discountModel.getProductId()) {
            throw new RuntimeException("For Product discounts, Kindly provide Product Id.");
        }
    }


    private DiscountModel mapToResponse(Discount out) {
        return DiscountModel.builder()
                .id(out.getId())
                .category(DiscountCategory.valueOf(out.getCategory()))
                .vendorGroupId(out.getVendorGroupId())
                .vendorId(out.getVendorId())
                .productId(out.getProductId())
                .name(out.getName())
                .type(DiscountType.valueOf(out.getType()))
                .value(out.getValue())
                .fromDate(out.getFromDate())
                .toDate(out.getToDate())
                .status(out.getStatus())
                .build();
    }
}
