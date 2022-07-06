package com.lea.couponsPart2.controllers;

import com.lea.couponsPart2.services.GuestService;
import com.lea.couponsPart2.utils.JWT;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guest")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:3000",allowedHeaders = "*")
public class GuestController {
    private final GuestService guestService;
   // private final JWT jwt;
    @GetMapping("/allCoupons")
    public ResponseEntity<?> getAllCoupons(@RequestHeader(name = "Authorization") String token){
       return new ResponseEntity<>(guestService.allCoupons(),HttpStatus.OK);
//        return ResponseEntity.ok()
//                .header("Authorization", jwt.generateToken(token))
//                .body(guestService.allCoupons());
    }
}
