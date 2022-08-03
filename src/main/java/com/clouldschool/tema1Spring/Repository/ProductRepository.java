package com.clouldschool.tema1Spring.Repository;

import com.clouldschool.tema1Spring.Model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {
    public void delete(Product product);
}
