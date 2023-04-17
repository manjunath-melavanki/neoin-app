package com.neoin.shop.dao;

import com.neoin.shop.jooq.Tables;
import com.neoin.shop.jooq.tables.Product;
import com.neoin.shop.model.ProductFilter;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private DSLContext context;
    private Long productSKU;
    private String productType;
    @Override
    public List<com.neoin.shop.entity.Product> getProducts(ProductFilter productFilter) {
        Product product = Tables.PRODUCT.as("product");
        Condition idCond = null != productFilter.getId() ? product.ID.eq(productFilter.getId()) : DSL.trueCondition();
        Condition catCond = null != productFilter.getProductCategoryId() ? product.PRODUCT_CATEGORY_ID.eq(productFilter.getProductCategoryId()) : DSL.trueCondition();
        Condition discountCond = null != productFilter.getDiscountId() ? product.DISCOUNT_ID.eq(productFilter.getDiscountId()) : DSL.trueCondition();
        Condition vendIdCond = null != productFilter.getVendorId() ? product.VENDOR_ID.eq(productFilter.getVendorId()) : DSL.trueCondition();
        Condition prodNameCond = null != productFilter.getProductName() ? product.PRODUCT_NAME.eq(productFilter.getProductName()) : DSL.trueCondition();
        Condition skuCond = null != productFilter.getProductSKU() ? product.PRODUCT_SKU.eq( productFilter.getProductSKU() ) : DSL.trueCondition();
        Condition typeCond = null != productFilter.getProductType() ? product.PRODUCT_TYPE.eq(productFilter.getProductType()) : DSL.trueCondition();
        return context
                .selectFrom(product)
                .where(idCond)
                .and(catCond).and(discountCond).and(vendIdCond).and(prodNameCond).and(skuCond).and(typeCond)
                .fetchInto(com.neoin.shop.entity.Product.class);
    }
}
