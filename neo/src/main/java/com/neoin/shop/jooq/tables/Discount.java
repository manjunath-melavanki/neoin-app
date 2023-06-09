/*
 * This file is generated by jOOQ.
 */
package com.neoin.shop.jooq.tables;


import com.neoin.shop.jooq.DefaultSchema;
import com.neoin.shop.jooq.Keys;
import com.neoin.shop.jooq.tables.records.DiscountRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row15;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Discount extends TableImpl<DiscountRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>discount</code>
     */
    public static final Discount DISCOUNT = new Discount();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DiscountRecord> getRecordType() {
        return DiscountRecord.class;
    }

    /**
     * The column <code>discount.id</code>.
     */
    public final TableField<DiscountRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>discount.created_at</code>.
     */
    public final TableField<DiscountRecord, Long> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>discount.created_by</code>.
     */
    public final TableField<DiscountRecord, String> CREATED_BY = createField(DSL.name("created_by"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>discount.modified_at</code>.
     */
    public final TableField<DiscountRecord, Long> MODIFIED_AT = createField(DSL.name("modified_at"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>discount.modified_by</code>.
     */
    public final TableField<DiscountRecord, String> MODIFIED_BY = createField(DSL.name("modified_by"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>discount.category</code>.
     */
    public final TableField<DiscountRecord, String> CATEGORY = createField(DSL.name("category"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>discount.from_date</code>.
     */
    public final TableField<DiscountRecord, Long> FROM_DATE = createField(DSL.name("from_date"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>discount.name</code>.
     */
    public final TableField<DiscountRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>discount.product_id</code>.
     */
    public final TableField<DiscountRecord, Long> PRODUCT_ID = createField(DSL.name("product_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>discount.status</code>.
     */
    public final TableField<DiscountRecord, Boolean> STATUS = createField(DSL.name("status"), SQLDataType.BIT, this, "");

    /**
     * The column <code>discount.to_date</code>.
     */
    public final TableField<DiscountRecord, Long> TO_DATE = createField(DSL.name("to_date"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>discount.type</code>.
     */
    public final TableField<DiscountRecord, String> TYPE = createField(DSL.name("type"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>discount.value</code>.
     */
    public final TableField<DiscountRecord, Double> VALUE = createField(DSL.name("value"), SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>discount.vendor_group_id</code>.
     */
    public final TableField<DiscountRecord, Long> VENDOR_GROUP_ID = createField(DSL.name("vendor_group_id"), SQLDataType.BIGINT, this, "");

    /**
     * The column <code>discount.vendor_id</code>.
     */
    public final TableField<DiscountRecord, Long> VENDOR_ID = createField(DSL.name("vendor_id"), SQLDataType.BIGINT, this, "");

    private Discount(Name alias, Table<DiscountRecord> aliased) {
        this(alias, aliased, null);
    }

    private Discount(Name alias, Table<DiscountRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>discount</code> table reference
     */
    public Discount(String alias) {
        this(DSL.name(alias), DISCOUNT);
    }

    /**
     * Create an aliased <code>discount</code> table reference
     */
    public Discount(Name alias) {
        this(alias, DISCOUNT);
    }

    /**
     * Create a <code>discount</code> table reference
     */
    public Discount() {
        this(DSL.name("discount"), null);
    }

    public <O extends Record> Discount(Table<O> child, ForeignKey<O, DiscountRecord> key) {
        super(child, key, DISCOUNT);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<DiscountRecord, Long> getIdentity() {
        return (Identity<DiscountRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<DiscountRecord> getPrimaryKey() {
        return Keys.KEY_DISCOUNT_PRIMARY;
    }

    @Override
    public List<UniqueKey<DiscountRecord>> getKeys() {
        return Arrays.<UniqueKey<DiscountRecord>>asList(Keys.KEY_DISCOUNT_PRIMARY);
    }

    @Override
    public Discount as(String alias) {
        return new Discount(DSL.name(alias), this);
    }

    @Override
    public Discount as(Name alias) {
        return new Discount(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Discount rename(String name) {
        return new Discount(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Discount rename(Name name) {
        return new Discount(name, null);
    }

    // -------------------------------------------------------------------------
    // Row15 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row15<Long, Long, String, Long, String, String, Long, String, Long, Boolean, Long, String, Double, Long, Long> fieldsRow() {
        return (Row15) super.fieldsRow();
    }
}
