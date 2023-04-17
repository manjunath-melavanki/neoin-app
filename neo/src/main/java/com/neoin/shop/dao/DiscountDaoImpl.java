package com.neoin.shop.dao;

import com.neoin.shop.jooq.Tables;
import com.neoin.shop.jooq.tables.Discount;
import com.neoin.shop.model.DiscountFilter;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiscountDaoImpl implements DiscountDao {
    @Autowired
    private DSLContext context;

    @Override
    public List<com.neoin.shop.entity.Discount> getDiscount(DiscountFilter discountFilter) {
        Discount discount = Tables.DISCOUNT.as("discount");
        Condition idCond = null != discountFilter.getId() ? discount.ID.eq(discountFilter.getId()) : DSL.trueCondition();
        Condition catCond = null != discountFilter.getCategory() ? discount.CATEGORY.eq(discountFilter.getCategory()) : DSL.trueCondition();
        Condition grpIdCond = null != discountFilter.getVendorGroupId() ? discount.VENDOR_GROUP_ID.eq(discountFilter.getVendorGroupId()) : DSL.trueCondition();
        Condition vendIdCond = null != discountFilter.getVendorId() ? discount.VENDOR_ID.eq(discountFilter.getVendorId()) : DSL.trueCondition();
        Condition prodIdCond = null != discountFilter.getProductId() ? discount.PRODUCT_ID.eq(discountFilter.getProductId()) : DSL.trueCondition();
        Condition nameCond = null != discountFilter.getName() ? discount.NAME.like("%" + discountFilter.getName() + "%") : DSL.trueCondition();
        Condition typeCond = null != discountFilter.getType() ? discount.TYPE.eq(discountFilter.getType()) : DSL.trueCondition();
        Condition valCond = null != discountFilter.getValue() ? discount.VALUE.eq(discountFilter.getValue()) : DSL.trueCondition();
        Condition dateCond = null != discountFilter.getDate() ? DSL.val(discountFilter.getDate()).between(discount.FROM_DATE, discount.TO_DATE) : DSL.trueCondition();

        return context
                .selectFrom(Tables.DISCOUNT)
                .where(idCond)
                .and(catCond).and(grpIdCond).and(vendIdCond).and(prodIdCond).and(nameCond).and(typeCond).and(valCond).and(dateCond)
                .fetchInto(com.neoin.shop.entity.Discount.class);
    }
}
