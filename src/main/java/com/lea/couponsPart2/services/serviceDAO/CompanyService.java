package com.lea.couponsPart2.services.serviceDAO;

import com.lea.couponsPart2.beans.Categories;
import com.lea.couponsPart2.beans.Company;
import com.lea.couponsPart2.beans.Coupon;
import com.lea.couponsPart2.exceptions.InvalidDateException;
import com.lea.couponsPart2.exceptions.NotExistException;

import java.util.List;

public interface CompanyService {

    int addCoupon(Coupon coupon) throws NotExistException;

    void updateCoupon(Coupon coupon) throws NotExistException;

    void deleteCoupon(int couponID) throws NotExistException;

    List<Coupon> getAllCompanyCoupons() throws NotExistException;

    List<Coupon> getAllCompanyCouponsByCategory(Categories category) throws NotExistException;

    List<Coupon> getAllCompanyCouponsByMaxPrice(double maxPrice) throws NotExistException;

    Company getCompanyDetails() throws NotExistException;
}
