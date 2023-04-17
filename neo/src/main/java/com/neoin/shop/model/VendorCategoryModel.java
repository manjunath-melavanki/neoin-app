package com.neoin.shop.model;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VendorCategoryModel {
    private Long id;
    @NonNull
    private String categoryName;
    private boolean Status;
    private int priority;
}
