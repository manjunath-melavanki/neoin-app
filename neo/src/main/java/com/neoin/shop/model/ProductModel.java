package com.neoin.shop.model;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductModel {
    private Long id;
    private Long productSKU;
    private String productName;
    private String productType;
    private String productManufacturer;
    private Double productPrice;
    private Long discountId;
    private Long vendorId;
    private Long productCategoryId;
    private String productShortDesc;
    private String productLongDesc;
    private String productThumb;
    private String productImage;
    private Long productUpdateDate;
    private Boolean productStatus;
}
