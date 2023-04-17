package com.neoin.shop.controller;

import com.neoin.shop.model.DiscountFilter;
import com.neoin.shop.model.DiscountModel;
import com.neoin.shop.service.DiscountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/discount")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @PostMapping("/get")
    public @ResponseBody
    ResponseEntity<List<DiscountModel>> getDiscount(@RequestBody DiscountFilter discountFilter) {
        log.info("DiscountModel {}", discountFilter);
        return new ResponseEntity<List<DiscountModel>>(discountService.getDiscount(discountFilter), HttpStatus.OK);
    }

    @PutMapping
    public @ResponseBody
    ResponseEntity<DiscountModel> updateDiscount(@RequestBody DiscountModel discountModel) {
        log.info("DiscountModel {}", discountModel);
        return new ResponseEntity<>(discountService.updateDiscount(discountModel), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<DiscountModel> createDiscount(@RequestBody DiscountModel discountModel) {
        log.info("DiscountModel {}", discountModel);
        return new ResponseEntity<>(discountService.createDiscount(discountModel), HttpStatus.OK);
    }
}
