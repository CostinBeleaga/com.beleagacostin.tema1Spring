package com.clouldschool.tema1Spring.Repository;

import com.clouldschool.tema1Spring.Model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {

    public Customer getById(int customerId);


}
