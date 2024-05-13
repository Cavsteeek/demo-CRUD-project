package com.cavsteek.bookseller.controller;

import com.cavsteek.bookseller.dto.DeliveryInfoDto;
import com.cavsteek.bookseller.model.DeliveryInfo;
import com.cavsteek.bookseller.model.Form;
import com.cavsteek.bookseller.service.DeliveryInfoService;
import com.cavsteek.bookseller.service.FormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/admin")
public class AdminController {
    private final FormService formService;
    private final DeliveryInfoService deliveryInfoService;
    @GetMapping("/form-info")
    public ResponseEntity<?> getFormInfo(){
        try {
            return ResponseEntity.ok(formService.getFormInfo());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to get Info" + e.getMessage());
        }
    }


    @PostMapping("/delivery-info/{formId}")
    public ResponseEntity<?> createDeliveryInfo(@PathVariable Long formId, @RequestBody DeliveryInfoDto deliveryInfoDto){
        try {
            DeliveryInfo deliveryInfo = deliveryInfoService.saveDeliveryInfo(formId, deliveryInfoDto);
            return new ResponseEntity<>(deliveryInfo, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to get Info" + e.getMessage());
        }

    }

    @GetMapping("/delivery-info")
    public ResponseEntity<?> getDeliveryInfo(){
        try {
            return ResponseEntity.ok(deliveryInfoService.getDeliveryInfo());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to get Info" + e.getMessage());
        }
    }
}