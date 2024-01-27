package com.cavsteek.bookseller.controller;

import com.cavsteek.bookseller.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/internal")
@RequiredArgsConstructor
public class InternalApiController {
    private UserService userService;

    @PutMapping("/make-admin/{username}")
    public ResponseEntity<?> makeAdmin(@PathVariable String username){
        userService.makeAdmin(username);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
