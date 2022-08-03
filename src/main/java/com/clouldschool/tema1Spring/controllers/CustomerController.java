package com.clouldschool.tema1Spring.controllers;

import com.clouldschool.tema1Spring.Model.Customer;
import com.clouldschool.tema1Spring.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers/all")
    public List<Customer> getAllCustomers()
    {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    @ResponseBody
    public Customer getCustomerById(@PathVariable(value="id")int customerid)
    {
        return customerService.getCustomerById(customerid);
    }

    @PostMapping("/customers")
    @ResponseBody
    public Customer insertCustomer(@RequestBody Customer customer)
    {
        return customerService.insertCustomer(customer);
    }

    @PostMapping("/customers/{id}")
    @ResponseBody
    public Customer updateCustomersById(@PathVariable(value="id")int customerid,@RequestBody Customer customer)
    {
        return customerService.updateCustomersById(customerid, customer);
    }
    @DeleteMapping("/customers/{id}")
    @ResponseBody
    public Customer deleteCustomerById(@PathVariable(value="id")int customerid)
    {
        return customerService.deleteCustomerById(customerid);
    }

}
