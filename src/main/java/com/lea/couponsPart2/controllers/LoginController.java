package com.lea.couponsPart2.controllers;

import com.lea.couponsPart2.beans.ClientDetails;
import com.lea.couponsPart2.exceptions.LoginException;
import com.lea.couponsPart2.services.LoginService;
import com.lea.couponsPart2.services.serviceImpl.AdminServiceImpl;
import com.lea.couponsPart2.services.serviceImpl.CompanyServiceImpl;
import com.lea.couponsPart2.services.serviceImpl.CustomerServiceImpl;
import com.lea.couponsPart2.utils.JWT;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowedHeaders = "*")
@RequestMapping("/")
@RequiredArgsConstructor
public class LoginController {
    private final JWT jwt;
    private final LoginService loginService;
    private final AdminServiceImpl adminService;
    private final CompanyServiceImpl companyService;
    private final CustomerServiceImpl customerService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody ClientDetails clientDetails) throws LoginException {
        if (loginService.login(clientDetails) == null) {
            throw new LoginException(clientDetails.getClientType());
        }
       // return new ResponseEntity<>(jwt.generateToken(clientDetails), HttpStatus.OK);
        return ResponseEntity.ok().header("Authorization", jwt.generateToken(clientDetails)).build();
    }

}
