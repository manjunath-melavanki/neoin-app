package com.neoin.shop.repository;

import com.neoin.shop.entity.VendorCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorCategoryRepository extends JpaRepository<VendorCategory, Long> {
    @Query(value = "SELECT * FROM vendor_category v WHERE v.status = 1", nativeQuery = true)
    List<VendorCategory> getAllActiveVendorCategories();
}
