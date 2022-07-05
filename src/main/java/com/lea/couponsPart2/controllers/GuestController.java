package com.lea.couponsPart2.controllers;

import com.lea.couponsPart2.services.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
@RequiredArgsConstructor
public class GuestController {
    private final GuestService guestService;

    @GetMapping("/allCoupons")
    public ResponseEntity<?> getAllCoupons(){
        return new ResponseEntity<>(guestService.allCoupons(),HttpStatus.OK);
    }
}
