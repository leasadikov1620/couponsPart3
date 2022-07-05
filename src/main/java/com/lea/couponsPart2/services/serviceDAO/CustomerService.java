package com.lea.couponsPart2.services.serviceDAO;

import com.lea.couponsPart2.beans.Categories;
import com.lea.couponsPart2.beans.Coupon;
import com.lea.couponsPart2.beans.Customer;
import com.lea.couponsPart2.exceptions.AlreadyExistsException;
import com.lea.couponsPart2.exceptions.NotExistException;

import java.util.List;

public interface CustomerService {

    void purchaseCoupon(int couponID) throws NotExistException, AlreadyExistsException;

    List<Coupon> getAllCustomerCoupons() throws NotExistException;

    List<Coupon> getAllCustomerCouponsByCategory(Categories category) throws NotExistException;

    List<Coupon> getAllCustomerCouponsByMaxPrice(double maxPrice) throws NotExistException;

    Customer getCustomerDetails() throws NotExistException;
}
