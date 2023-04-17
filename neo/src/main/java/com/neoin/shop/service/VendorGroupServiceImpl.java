package com.neoin.shop.service;

import com.neoin.shop.entity.VendorGroup;
import com.neoin.shop.model.VendorGroupModel;
import com.neoin.shop.repository.VendorGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendorGroupServiceImpl implements VendorGroupService {
    @Autowired
    private VendorGroupRepository groupRepository;

    @Override
    public VendorGroupModel updateVendorGroupById(VendorGroupModel groupModel, long id) {
        Optional<VendorGroup> groupOpt = groupRepository.findById(id);
        if (groupOpt.isPresent()) {
            VendorGroup group = groupOpt.get();
            group.setGroupName(groupModel.getGroupName());
            group.setStatus(groupModel.getStatus());
            group.setModifiedAt(System.currentTimeMillis());
            group.setModifiedBy("Test User");
            return mapToResponse(groupRepository.save(group));
        }
        return null;
    }

    @Override
    public VendorGroupModel findByVendorGroupId(long id) {
        return mapToResponse(groupRepository.findById(id).get());
    }

    @Override
    public List<VendorGroupModel> getAllVendorGroups() {
        return groupRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public List<VendorGroupModel> getAllActiveVendorGroups() {
        return groupRepository.getAllActiveVendorGroups().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public VendorGroupModel createVendorGroup(VendorGroupModel groupModel) {
        VendorGroup group = VendorGroup.builder()
                .groupName(groupModel.getGroupName())
                .Status(groupModel.getStatus())
                .createdAt(System.currentTimeMillis())
                .createdBy("Test User").build();

        return mapToResponse(groupRepository.save(group));
    }

    private VendorGroupModel mapToResponse(VendorGroup out) {
        return VendorGroupModel.builder()
                .id(out.getId())
                .groupName(out.getGroupName())
                .Status(out.getStatus())
                .build();
    }
}
