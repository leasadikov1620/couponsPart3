package com.lea.couponsPart2.controllers;


import com.lea.couponsPart2.beans.ClientType;
import com.lea.couponsPart2.beans.Company;
import com.lea.couponsPart2.beans.Customer;
import com.lea.couponsPart2.exceptions.LoginException;
import com.lea.couponsPart2.exceptions.NotExistException;
import com.lea.couponsPart2.exceptions.TokenException;
import com.lea.couponsPart2.services.serviceImpl.AdminServiceImpl;
import com.lea.couponsPart2.utils.JWT;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowedHeaders = "*")
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final JWT jwt;
    private final AdminServiceImpl adminService;

    @PostMapping("/addCompany")
    public ResponseEntity<?> addCompany(@RequestHeader(name = "Authorization") String token, @RequestBody Company company) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.ADMIN);



        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(adminService.addCompany(company));
    }

    @PutMapping("/updateCompany")
    public ResponseEntity<?> updateCompany(@RequestHeader(name = "Authorization") String token, @RequestBody Company company) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.ADMIN);

        adminService.updateCompany(company);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body("Company #" + company.getId() + " updated successfully");
    }

    @DeleteMapping("/deleteCompany/{companyID}")
    public ResponseEntity<?> deleteCompany(@RequestHeader(name = "Authorization") String token, @PathVariable int companyID) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.ADMIN);

        adminService.deleteCompany(companyID);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body("Company #" + companyID + " deleted successfully");
    }

    @GetMapping("/getAllCompanies")
    public ResponseEntity<?> getAllCompanies(@RequestHeader(name = "Authorization") String token) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.ADMIN);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(adminService.getAllCompanies());
    }

    @GetMapping("/getOneCompany/{companyID}")
    public ResponseEntity<?> getCompanyByID(@RequestHeader(name = "Authorization") String token, @PathVariable int companyID) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.ADMIN);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(adminService.getCompanyByID(companyID));
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<?> addCustomer(@RequestHeader(name = "Authorization") String token, @RequestBody Customer customer) throws TokenException, LoginException, NotExistException {
        jwt.checkUser(token, ClientType.ADMIN);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(adminService.addCustomer(customer));
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<?> updateCustomer(@RequestHeader(name = "Authorization") String token, @RequestBody Customer customer) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.ADMIN);

        adminService.updateCustomer(customer);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body("Customer #" + customer.getId() + " updated successfully");
    }

    @DeleteMapping("/deleteCustomer/{customerID}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> deleteCustomer(@RequestHeader(name = "Authorization") String token, @PathVariable int customerID) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.ADMIN);

        adminService.deleteCustomer(customerID);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body("Customer #" + customerID + " updated successfully");
    }

    @GetMapping("getAllCustomers")
    public ResponseEntity<?> getAllCustomers(@RequestHeader(name = "Authorization") String token) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.ADMIN);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token.replace("Bearer ", "")))
                .body(adminService.getAllCustomers());
    }

    @GetMapping("/getOneCustomer/{customerID}")
    public ResponseEntity<?> getCustomerByID(@RequestHeader(name = "Authorization") String token, @PathVariable int customerID) throws NotExistException, TokenException, LoginException {
        jwt.checkUser(token, ClientType.ADMIN);

        return ResponseEntity.ok()
                .header("Authorization", jwt.generateToken(token))
                .body(adminService.getCustomerByID(customerID));
    }

}
