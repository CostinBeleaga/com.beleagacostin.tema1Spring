package com.clouldschool.tema1Spring.Service;

import com.clouldschool.tema1Spring.Model.Customer;
import com.clouldschool.tema1Spring.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    List<Customer> list = new ArrayList<>();

    public List<Customer> getAllCustomers() {
        List<Customer> aux = new ArrayList<>();
        customerRepository.findAll().iterator().forEachRemaining(aux::add);
        return aux;
    }

    public Customer getCustomerById (int customerid)
    {
        Customer customer = customerRepository.findById(customerid).get();
        return customer;
    }

    public Customer insertCustomer (Customer customer)
    {
        Customer c = customerRepository.save(customer);
        return c;
    }
    public Customer updateCustomersById(int customerid, Customer customer)
    {
        Customer c = customerRepository.findById(customerid).get();
        if (customer.getName() != null)
            c.setName(customer.getName());
        if (customer.getEmail() != null)
            c.setEmail(customer.getEmail());
        customerRepository.save(c);
        return c;
    }

    public Customer deleteCustomerById(int customerid)
    {
        Customer customer = customerRepository.findById(customerid).get();
        customerRepository.delete(customer);
        return customer;
    }

}


