package com.neoin.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "PRODUCT_SKU")
    private Long productSKU;
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PRODUCT_TYPE")
    private String productType;
    @Column(name = "PRODUCT_MANUFACTURER")
    private String productManufacturer;
    @Column(name = "PRODUCT_PRICE")
    private Double productPrice;
    @Column(name = "DISCOUNT_ID")
    private Long discountId;
    @Column(name = "VENDOR_ID")
    private Long vendorId;
    @Column(name = "PRODUCT_CATEGORY_ID")
    private Long productCategoryId;
    @Column(name = "PRODUCT_SHORT_DESC")
    private String productShortDesc;
    @Column(name = "PRODUCT_LONG_DESC")
    private String productLongDesc;
    @Column(name = "PRODUCT_THUMB")
    private String productThumb;
    @Column(name = "PRODUCT_IMAGE")
    private String productImage;
    @Column(name = "PRODUCT_UPDATED_DATE")
    private Long productUpdateDate;
    @Column(name = "PRODUCT_STATUS")
    private Boolean productStatus;
}
