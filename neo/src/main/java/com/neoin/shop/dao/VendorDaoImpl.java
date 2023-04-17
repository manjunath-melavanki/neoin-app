package com.neoin.shop.dao;

import com.neoin.shop.jooq.tables.Vendor;
import com.neoin.shop.jooq.tables.VendorCategory;
import com.neoin.shop.jooq.tables.VendorCategoryMap;
import com.neoin.shop.jooq.tables.VendorGroup;
import com.neoin.shop.model.VendorCategoryModel;
import com.neoin.shop.model.VendorFilter;
import com.neoin.shop.model.VendorGroupModel;
import com.neoin.shop.model.VendorModel;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

import static com.neoin.shop.jooq.Tables.*;

@Repository
public class VendorDaoImpl implements VendorDao {

    @Autowired
    private DSLContext context;

    @Override
    public List<VendorModel> findAll(VendorFilter vendorFilter) {

        Vendor vendor = VENDOR.as("vendor");
        VendorGroup group = VENDOR_GROUP.as("group");
        VendorCategory category = VENDOR_CATEGORY.as("category");
        VendorCategoryMap venCatMap = VENDOR_CATEGORY_MAP.as("venCatMap");

        Condition idCondition = null != vendorFilter.getId() ? vendor.ID.eq(vendorFilter.getId()) : DSL.trueCondition();
        Condition categoryCondition = null != vendorFilter.getCategories() && !vendorFilter.getCategories().isEmpty() ? venCatMap.CATEGORY_ID.in(vendorFilter.getCategories()) : DSL.trueCondition();
        Condition groupCondition = null != vendorFilter.getGroupId() ? vendor.GROUP_ID.eq(vendorFilter.getGroupId()) : DSL.trueCondition();
        Condition nameCondition = null != vendorFilter.getName() ? vendor.NAME.like("%"+ vendorFilter.getName()+"%") : DSL.trueCondition();

        Result<Record> resultSet = context
                .select(vendor.asterisk(), group.GROUP_NAME, group.STATUS.as("groupStatus"), venCatMap.CATEGORY_ID, category.CATEGORY_NAME, category.PRIORITY, category.STATUS.as("categoryStatus"))
                .from(vendor
                        .join(group).on(vendor.GROUP_ID.eq(group.ID))
                        .join(venCatMap).on(vendor.ID.eq(venCatMap.VENDOR_ID))
                        .join(category).on(category.ID.eq(venCatMap.CATEGORY_ID)))
                .where(idCondition)
                .and(categoryCondition)
                .and(groupCondition)
                .and(nameCondition)
                .fetch();
        Map<Long, VendorModel> vendors = new LinkedHashMap<>();
        for (Record record : resultSet) {
            if (vendors.containsKey(record.get(Vendor.VENDOR.ID))) {
                vendors.get(record.get(Vendor.VENDOR.ID)).getCategories().add(VendorCategoryModel
                        .builder()
                        .id(record.get(VendorCategory.VENDOR_CATEGORY.ID))
                        .categoryName(record.get(VendorCategory.VENDOR_CATEGORY.CATEGORY_NAME))
                        .priority(record.get(VendorCategory.VENDOR_CATEGORY.PRIORITY))
                        .Status(record.get(VendorCategory.VENDOR_CATEGORY.STATUS))
                        .build());
            } else {
                vendors.put(record.get(Vendor.VENDOR.ID), getVendorModel(record));
            }
        }

        return new ArrayList<>(vendors.values());
    }

    private VendorModel getVendorModel(Record record) {
        Set<VendorCategoryModel> cats = new LinkedHashSet<>(5);
        cats.add(VendorCategoryModel.builder()
                .id(record.get(VendorCategory.VENDOR_CATEGORY.ID))
                .categoryName(record.get(VendorCategory.VENDOR_CATEGORY.CATEGORY_NAME))
                .priority(record.get(VendorCategory.VENDOR_CATEGORY.PRIORITY))
                .Status(record.get(VendorCategory.VENDOR_CATEGORY.STATUS))
                .build()
        );

        return VendorModel.builder()
                .id(record.get(Vendor.VENDOR.ID))
                .address1(record.get(Vendor.VENDOR.ADDRESS1))
                .address2(record.get(Vendor.VENDOR.ADDRESS2))
                .area(record.get(Vendor.VENDOR.AREA))
                .city(record.get(Vendor.VENDOR.CITY))
                .code(record.get(Vendor.VENDOR.CODE))
                .country(record.get(Vendor.VENDOR.COUNTRY))
                .image(record.get(Vendor.VENDOR.IMAGE))
                .landMark(record.get(Vendor.VENDOR.LAND_MARK))
                .latitude(record.get(Vendor.VENDOR.LATITUDE))
                .longDesc(record.get(Vendor.VENDOR.LONG_DESC))
                .longitude(record.get(Vendor.VENDOR.LONGITUDE))
                .name(record.get(Vendor.VENDOR.NAME))
                .shortDesc(record.get(Vendor.VENDOR.SHORT_DESC))
                .state(record.get(Vendor.VENDOR.STATE))
                .status(record.get(Vendor.VENDOR.STATUS))
                .thumb(record.get(Vendor.VENDOR.THUMB))
                .vendorGroupModel(VendorGroupModel.builder()
                        .id(record.get(Vendor.VENDOR.GROUP_ID))
                        .groupName(record.get(VendorGroup.VENDOR_GROUP.GROUP_NAME))
                        .Status(record.get(VendorGroup.VENDOR_GROUP.STATUS))
                        .build())
                .categories(cats)
                .build();

    }
}
