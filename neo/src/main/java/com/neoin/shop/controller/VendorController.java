package com.neoin.shop.controller;

import com.neoin.shop.model.VendorFilter;
import com.neoin.shop.model.VendorModel;
import com.neoin.shop.service.VendorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping("/getAll")
    public @ResponseBody
    ResponseEntity<List<VendorModel>> getVendor(@RequestBody VendorFilter vendorFilter) {
        return new ResponseEntity<>(vendorService.getVendor(vendorFilter), HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody
    ResponseEntity<VendorModel> updateVendor(@RequestBody VendorModel vendorModel) {
        return new ResponseEntity<>(vendorService.updateVendor(vendorModel), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<VendorModel> createVendor(@RequestBody VendorModel vendorModel) {
        return new ResponseEntity<>(vendorService.createVendor(vendorModel), HttpStatus.OK);
    }
}
