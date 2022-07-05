package com.lea.couponsPart2.clr;

import com.lea.couponsPart2.beans.Categories;
import com.lea.couponsPart2.beans.ClientDetails;
import com.lea.couponsPart2.beans.ClientType;
import com.lea.couponsPart2.beans.Coupon;
import com.lea.couponsPart2.repositories.CouponRepo;
import com.lea.couponsPart2.services.LoginService;
import com.lea.couponsPart2.services.serviceImpl.CompanyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

//@Component
@RequiredArgsConstructor
public class MyTest implements CommandLineRunner {
    private final CouponRepo couponRepo;
    private final LoginService loginService;

    @Override
    public void run(String... args) throws Exception {
        CompanyServiceImpl company1 = (CompanyServiceImpl) loginService.login(
                new ClientDetails("no-reply@oren.inc", "orenInc", ClientType.COMPANY));
        company1.addCoupon((Coupon.builder()
//                .company(company1.getCompanyDetails())
                //.category(categoryRepo.getById(1))
                .category(Categories.FOOD)
                .title("doger")
                .description("blat")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(7)))
                .amount(130)
                .price(1990.90)
                .image("https://artbreeder.b-cdn.net/imgs/0959cc21a44aa721a615.jpeg?width=256")
                .build()));

    }
}
