package com.neoin.shop.model;

import lombok.*;

import java.util.Set;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VendorModel {
    private Long id;
    private Set<VendorCategoryModel> categories;
    private VendorGroupModel vendorGroupModel;
    private String code;
    @NonNull
    private String name;
    private String shortDesc;
    private String longDesc;
    private String thumb;
    private String image;
    private String address1;
    private String address2;
    private String landMark;
    private String area;
    private String city;
    private String state;
    private String country;
    private Boolean status;
    private Double latitude;
    private Double longitude;
}
