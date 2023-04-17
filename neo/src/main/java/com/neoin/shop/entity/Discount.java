package com.neoin.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "discount")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Discount extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "VENDOR_GROUP_ID")
    private Long vendorGroupId;
    @Column(name = "VENDOR_ID")
    private Long vendorId;
    @Column(name = "PRODUCT_ID")
    private Long productId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "VALUE")
    private Double value;
    @Column(name = "FROM_DATE")
    private Long fromDate;
    @Column(name = "TO_DATE")
    private Long toDate;
    @Column(name = "STATUS")
    private Boolean status;
}
