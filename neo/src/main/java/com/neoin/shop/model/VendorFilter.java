package com.neoin.shop.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class VendorFilter extends BaseFilter {
    private Set<Long> categories;
    private Long groupId;
    private String name;
}
