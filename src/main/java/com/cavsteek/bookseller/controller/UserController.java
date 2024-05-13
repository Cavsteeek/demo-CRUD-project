package com.cavsteek.bookseller.controller;

import com.cavsteek.bookseller.model.Form;
import com.cavsteek.bookseller.service.FormService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final FormService formService;
    @PostMapping("/order-form")
    public ResponseEntity<?> newForm (@RequestBody Form form){
        try{
            formService.saveForm(form);
            return ResponseEntity.ok("Saved Successfully");
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Unable to save" + e.getMessage());
        }
    }
}