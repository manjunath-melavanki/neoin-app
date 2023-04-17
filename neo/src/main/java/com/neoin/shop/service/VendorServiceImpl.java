package com.neoin.shop.service;

import com.neoin.shop.dao.VendorDao;
import com.neoin.shop.entity.Vendor;
import com.neoin.shop.entity.VendorCategoryMap;
import com.neoin.shop.model.VendorCategoryModel;
import com.neoin.shop.model.VendorFilter;
import com.neoin.shop.model.VendorGroupModel;
import com.neoin.shop.model.VendorModel;
import com.neoin.shop.repository.VendorCategoryMapRepository;
import com.neoin.shop.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {
    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private VendorCategoryMapRepository vendorCategoryMapRepository;
    @Autowired
    private VendorDao vendorDao;

    @Override
    public VendorModel createVendor(VendorModel vendorModel) {
        Vendor vendor = mapToVendorEntity(vendorModel)
                .createdAt(System.currentTimeMillis())
                .createdBy("Test User")
                .build();
        Vendor vendorOutput = vendorRepository.save(vendor);

        return mapToResponse(vendorOutput, saveVendorCategories(vendorModel.getCategories(), vendorOutput.getId()));
    }

    private List<VendorCategoryMap> saveVendorCategories(Set<VendorCategoryModel> categories, Long id) {
        return vendorCategoryMapRepository.saveAll(categories.stream().map(v -> VendorCategoryMap.builder().vendorId(id).categoryId(v.getId()).build()).collect(Collectors.toList()));
    }

    private Vendor.VendorBuilder<?, ?> mapToVendorEntity(VendorModel vendorModel) {
        return Vendor.builder()
                .address1(vendorModel.getAddress1())
                .address2(vendorModel.getAddress2())
                .area(vendorModel.getArea())
                .city(vendorModel.getCity())
                .code(vendorModel.getCode())
                .country(vendorModel.getCountry())
                .groupId(vendorModel.getVendorGroupModel().getId())
                .image(vendorModel.getImage())
                .landMark(vendorModel.getLandMark())
                .latitude(vendorModel.getLatitude())
                .longDesc(vendorModel.getLongDesc())
                .longitude(vendorModel.getLongitude())
                .name(vendorModel.getName())
                .shortDesc(vendorModel.getShortDesc())
                .state(vendorModel.getState())
                .status(vendorModel.getStatus())
                .thumb(vendorModel.getThumb());

    }

    @Transactional
    @Override
    public VendorModel updateVendor(VendorModel vendorModel) {
        Vendor v = vendorRepository.getById(vendorModel.getId());
        if (null != v.getId()) {
            v = mapToVendorEntity(vendorModel)
                    .id(v.getId())
                    .createdAt(v.getCreatedAt())
                    .createdBy(v.getCreatedBy())
                    .modifiedAt(System.currentTimeMillis())
                    .modifiedBy("Test User")
                    .build();
            Vendor vendorOutput = vendorRepository.save(v);
            vendorCategoryMapRepository.deleteAllByVendorId(v.getId());
            return mapToResponse(vendorOutput, saveVendorCategories(vendorModel.getCategories(), vendorOutput.getId()));
        } else {
            throw new RuntimeException("Vendor not found");
        }
    }

    @Override
    public List<VendorModel> getVendor(VendorFilter vendorFilter) {
        return vendorDao.findAll(vendorFilter);
    }

    private VendorModel mapToResponse(Vendor outputVendor, List<VendorCategoryMap> vendorCategories) {
        return VendorModel.builder()
                .id(outputVendor.getId())
                .address1(outputVendor.getAddress1())
                .address2(outputVendor.getAddress2())
                .area(outputVendor.getArea())
                .categories(vendorCategories.stream().map(vendorCategoryMap -> VendorCategoryModel.builder().id(vendorCategoryMap.getId()).build()).collect(Collectors.toSet()))
                .city(outputVendor.getCity())
                .code(outputVendor.getCode())
                .country(outputVendor.getCountry())
                .vendorGroupModel(VendorGroupModel.builder().id(outputVendor.getGroupId()).build())
                .image(outputVendor.getImage())
                .landMark(outputVendor.getLandMark())
                .latitude(outputVendor.getLatitude())
                .longDesc(outputVendor.getLongDesc())
                .longitude(outputVendor.getLongitude())
                .name(outputVendor.getName())
                .shortDesc(outputVendor.getShortDesc())
                .state(outputVendor.getState())
                .status(outputVendor.getStatus())
                .thumb(outputVendor.getThumb())
                .build();
    }
}
