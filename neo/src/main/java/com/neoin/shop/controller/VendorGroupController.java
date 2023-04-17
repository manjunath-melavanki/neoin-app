package com.neoin.shop.controller;

import com.neoin.shop.model.VendorGroupModel;
import com.neoin.shop.service.VendorGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vendor/group")
public class VendorGroupController {

    @Autowired
    private VendorGroupService groupService;


    @PutMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<VendorGroupModel> updateVendorGroupById(@RequestBody VendorGroupModel groupModel, @PathVariable("id") long id) {
        return new ResponseEntity<VendorGroupModel>(groupService.updateVendorGroupById(groupModel, id), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<VendorGroupModel> findByVendorGroupId(@PathVariable("id") long id) {
        return new ResponseEntity<VendorGroupModel>(groupService.findByVendorGroupId(id), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody
    ResponseEntity<List<VendorGroupModel>> getAllVendorGroups() {
        log.info("Fetching vendor groups");
        return new ResponseEntity<List<VendorGroupModel>>(groupService.getAllVendorGroups(), HttpStatus.OK);
    }

    @GetMapping(path = "/active")
    public @ResponseBody
    ResponseEntity<List<VendorGroupModel>> getAllActiveVendorGroups() {
        return new ResponseEntity<List<VendorGroupModel>>(groupService.getAllActiveVendorGroups(), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<VendorGroupModel> createVendorGroup(@RequestBody VendorGroupModel groupModel) {
        log.info("VendorCategoryModel {}", groupModel);
        return new ResponseEntity<VendorGroupModel>(groupService.createVendorGroup(groupModel), HttpStatus.OK);
    }

}
