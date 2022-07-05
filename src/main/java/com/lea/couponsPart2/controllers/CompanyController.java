package com.lea.couponsPart2.controllers;

import com.lea.couponsPart2.beans.Categories;
import com.lea.couponsPart2.beans.ClientType;
import com.lea.couponsPart2.beans.Coupon;
import com.lea.couponsPart2.exceptions.InvalidDateException;
import com.lea.couponsPart2.exceptions.LoginException;
import com.lea.couponsPart2.exceptions.NotExistException;
import com.lea.couponsPart2.exceptions.TokenException;
import com.lea.couponsPart2.services.serviceImpl.CompanyServiceImpl;
import com.lea.couponsPart2.utils.JWT;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowedHeaders = "*")
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final JWT jwt;
    private final CompanyServiceImpl companyService;

    @PostMapping("/addCoupon")
    public ResponseEntity<?> addCoupon(@RequestHeader(name = "Authorization") String token, @RequestBody Coupon coupon) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.COMPANY);



        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(companyService.addCoupon(coupon));
    }

    @PutMapping("/updateCoupon")
    public ResponseEntity<?> updateCoupon(@RequestHeader(name = "Authorization") String token, @RequestBody Coupon coupon) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.COMPANY);

        companyService.updateCoupon(coupon);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body("Coupon #" + coupon.getId() + " updated Successfully");
    }

    @DeleteMapping("/deleteCoupon/{couponID}")
    public ResponseEntity<?> deleteCoupon(@RequestHeader(name = "Authorization") String token, @PathVariable int couponID) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.COMPANY);

        companyService.deleteCoupon(couponID);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body("Coupon #" + couponID + " deleted Successfully");
    }

    @GetMapping("/getAllCompanyCoupons")
    public ResponseEntity<?> getAllCompanyCoupons(@RequestHeader(name = "Authorization") String token) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.COMPANY);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(companyService.getAllCompanyCoupons());
    }

    @GetMapping("/getCouponByCategory/{category}")
    public ResponseEntity<?> getAllCompanyCouponsByCategory(@RequestHeader(name = "Authorization") String token, @PathVariable Categories category) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.COMPANY);
     //   companyService.getAllCompanyCouponsByCategory(category);
        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(companyService.getAllCompanyCouponsByCategory(category));
             //   .body("got by category");
    }

    @GetMapping("/getCouponByMaxPrice/{maxPrice}")
    public ResponseEntity<?> getAllCompanyCouponsByMaxPrice(@RequestHeader(name = "Authorization") String token, @PathVariable double maxPrice) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.COMPANY);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(companyService.getAllCompanyCouponsByMaxPrice(maxPrice));
    }

    @GetMapping("/getCompanyDetails")
    public ResponseEntity<?> getCompanyDetails(@RequestHeader(name = "Authorization") String token) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.COMPANY);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(companyService.getCompanyDetails());
    }

}
