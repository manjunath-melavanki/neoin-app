package com.neoin.shop.repository;

import com.neoin.shop.entity.VendorGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorGroupRepository extends JpaRepository<VendorGroup, Long> {
    @Query(value = "SELECT * FROM vendor_group v WHERE v.status = 1", nativeQuery = true)
    List<VendorGroup> getAllActiveVendorGroups();
}
