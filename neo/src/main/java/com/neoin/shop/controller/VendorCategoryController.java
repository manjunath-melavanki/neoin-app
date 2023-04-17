package com.neoin.shop.controller;

import com.neoin.shop.model.VendorCategoryModel;
import com.neoin.shop.service.VendorCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vendor/category")
public class VendorCategoryController {

    @Autowired
    private VendorCategoryService categoryService;

    @PutMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<VendorCategoryModel> updateVendorCategoryById(@RequestBody VendorCategoryModel vendorCategory, @PathVariable("id") long id) {
        return new ResponseEntity<VendorCategoryModel>(categoryService.updateVendorCategoryById(vendorCategory, id), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity<VendorCategoryModel> findByVendorCategoryId(@PathVariable("id") long id) {
        return new ResponseEntity<VendorCategoryModel>(categoryService.findByVendorCategoryId(id), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody
    ResponseEntity<List<VendorCategoryModel>> getAllVendorCategories() {
        return new ResponseEntity<List<VendorCategoryModel>>(categoryService.getAllVendorCategories(), HttpStatus.OK);
    }

    @GetMapping(path = "/active")
    public @ResponseBody
    ResponseEntity<List<VendorCategoryModel>> getAllActiveVendorCategories() {
        return new ResponseEntity<List<VendorCategoryModel>>(categoryService.getAllActiveVendorCategories(), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<VendorCategoryModel> createVendorCategory(@RequestBody VendorCategoryModel vendorCategory) {
        log.info("VendorCategoryModel {}", vendorCategory);
        return new ResponseEntity<VendorCategoryModel>(categoryService.createVendorCategory(vendorCategory), HttpStatus.OK);
    }

}
