package com.lea.couponsPart2.services;

import com.lea.couponsPart2.beans.Coupon;
import com.lea.couponsPart2.repositories.CouponRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class GuestService {
    private final CouponRepo couponRepo;

    public List<Coupon> allCoupons(){
      return couponRepo.findAll();
    }
}
