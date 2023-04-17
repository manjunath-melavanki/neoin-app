package com.neoin.shop.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DiscountFilter extends BaseFilter{
    private String category;
    private Long vendorGroupId;
    private Long vendorId;
    private Long productId;
    private String name;
    private String type;
    private Double value;
    private Long date;
}
