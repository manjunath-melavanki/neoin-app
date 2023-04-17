/*
 * This file is generated by jOOQ.
 */
package com.neoin.shop.jooq.tables.records;


import com.neoin.shop.jooq.tables.VendorCategoryMap;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VendorCategoryMapRecord extends UpdatableRecordImpl<VendorCategoryMapRecord> implements Record3<Long, Long, Long> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>vendor_category_map.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>vendor_category_map.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>vendor_category_map.category_id</code>.
     */
    public void setCategoryId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>vendor_category_map.category_id</code>.
     */
    public Long getCategoryId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>vendor_category_map.vendor_id</code>.
     */
    public void setVendorId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>vendor_category_map.vendor_id</code>.
     */
    public Long getVendorId() {
        return (Long) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Long, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Long, Long, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return VendorCategoryMap.VENDOR_CATEGORY_MAP.ID;
    }

    @Override
    public Field<Long> field2() {
        return VendorCategoryMap.VENDOR_CATEGORY_MAP.CATEGORY_ID;
    }

    @Override
    public Field<Long> field3() {
        return VendorCategoryMap.VENDOR_CATEGORY_MAP.VENDOR_ID;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getCategoryId();
    }

    @Override
    public Long component3() {
        return getVendorId();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getCategoryId();
    }

    @Override
    public Long value3() {
        return getVendorId();
    }

    @Override
    public VendorCategoryMapRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public VendorCategoryMapRecord value2(Long value) {
        setCategoryId(value);
        return this;
    }

    @Override
    public VendorCategoryMapRecord value3(Long value) {
        setVendorId(value);
        return this;
    }

    @Override
    public VendorCategoryMapRecord values(Long value1, Long value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached VendorCategoryMapRecord
     */
    public VendorCategoryMapRecord() {
        super(VendorCategoryMap.VENDOR_CATEGORY_MAP);
    }

    /**
     * Create a detached, initialised VendorCategoryMapRecord
     */
    public VendorCategoryMapRecord(Long id, Long categoryId, Long vendorId) {
        super(VendorCategoryMap.VENDOR_CATEGORY_MAP);

        setId(id);
        setCategoryId(categoryId);
        setVendorId(vendorId);
    }
}
