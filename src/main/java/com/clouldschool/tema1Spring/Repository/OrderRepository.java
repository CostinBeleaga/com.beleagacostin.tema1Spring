package com.clouldschool.tema1Spring.Repository;

import com.clouldschool.tema1Spring.Model.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orders,Integer> {
    public List<Orders> findAll();
}
