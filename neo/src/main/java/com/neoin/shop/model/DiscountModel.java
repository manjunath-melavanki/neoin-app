package com.neoin.shop.model;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiscountModel {
    private Long id;
    private DiscountCategory category;
    private Long vendorGroupId;
    private Long vendorId;
    private Long productId;
    private String name;
    private DiscountType type;
    private Double value;
    private Long fromDate;
    private Long toDate;
    private Boolean status;
}
