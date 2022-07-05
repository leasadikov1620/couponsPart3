package com.lea.couponsPart2.services;

import com.lea.couponsPart2.repositories.CompanyRepo;
import com.lea.couponsPart2.repositories.CouponRepo;
import com.lea.couponsPart2.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ClientService {
   // @Autowired
   // protected CategoryRepo categoryRepo;

    @Autowired
    protected CompanyRepo companyRepo;

    @Autowired
    protected CustomerRepo customerRepo;

    @Autowired
    protected CouponRepo couponRepo;

    public abstract boolean login(String email, String password);
}
