package com.neoin.shop.model;

import com.neoin.shop.entity.Discount;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VendorGroupModel {
    private Long id;
    @NonNull
    private String groupName;
    private Boolean Status;
}
