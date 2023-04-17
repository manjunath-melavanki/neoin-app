/*
 * This file is generated by jOOQ.
 */
package com.neoin.shop.jooq;


import com.neoin.shop.jooq.tables.Discount;
import com.neoin.shop.jooq.tables.Product;
import com.neoin.shop.jooq.tables.Vendor;
import com.neoin.shop.jooq.tables.VendorCategory;
import com.neoin.shop.jooq.tables.VendorCategoryMap;
import com.neoin.shop.jooq.tables.VendorGroup;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>DEFAULT_SCHEMA</code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * The table <code>discount</code>.
     */
    public final Discount DISCOUNT = Discount.DISCOUNT;

    /**
     * The table <code>product</code>.
     */
    public final Product PRODUCT = Product.PRODUCT;

    /**
     * The table <code>vendor</code>.
     */
    public final Vendor VENDOR = Vendor.VENDOR;

    /**
     * The table <code>vendor_category</code>.
     */
    public final VendorCategory VENDOR_CATEGORY = VendorCategory.VENDOR_CATEGORY;

    /**
     * The table <code>vendor_category_map</code>.
     */
    public final VendorCategoryMap VENDOR_CATEGORY_MAP = VendorCategoryMap.VENDOR_CATEGORY_MAP;

    /**
     * The table <code>vendor_group</code>.
     */
    public final VendorGroup VENDOR_GROUP = VendorGroup.VENDOR_GROUP;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            Discount.DISCOUNT,
            Product.PRODUCT,
            Vendor.VENDOR,
            VendorCategory.VENDOR_CATEGORY,
            VendorCategoryMap.VENDOR_CATEGORY_MAP,
            VendorGroup.VENDOR_GROUP);
    }
}
