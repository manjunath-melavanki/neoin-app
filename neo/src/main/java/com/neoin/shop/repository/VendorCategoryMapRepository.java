package com.neoin.shop.repository;

import com.neoin.shop.entity.VendorCategoryMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorCategoryMapRepository extends JpaRepository<VendorCategoryMap, Long> {
    @Modifying
    @Query(value = "DELETE FROM vendor_category_map v WHERE v.vendor_id =?1", nativeQuery = true)
    void deleteAllByVendorId(Long id);
}
