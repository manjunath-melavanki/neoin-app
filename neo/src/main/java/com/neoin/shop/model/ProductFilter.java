package com.neoin.shop.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductFilter extends BaseFilter {
    private Long productSKU;
    private String productName;
    private String productType;
    private Long discountId;
    private Long vendorId;
    private Long productCategoryId;
}
