package com.clouldschool.tema1Spring.Service;

import com.clouldschool.tema1Spring.Model.Product;
import com.clouldschool.tema1Spring.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    List<Product> list = new ArrayList<>();

    public List<Product> getAllProducts() {
        List<Product> aux = new ArrayList<>();
        productRepository.findAll().iterator().forEachRemaining(aux::add);
        return aux;
    }

    public Product getProductById (int productid)
    {
        Product product = productRepository.findById(productid).get();
        return product;
    }

    public Product insertProduct (Product product)
    {
        Product p = productRepository.save(product);
        return p;
    }
    public Product updateProductsById(int productid, Product product)
    {
        Product p = productRepository.findById(productid).get();
        if (product.getName() != null)
            p.setName(product.getName());
        if (product.getPrice() != null)
            p.setPrice(product.getPrice());
        productRepository.save(p);
        return p;
    }

    public Product deleteProductById(int productid)
    {
        Product product = productRepository.findById(productid).get();
        productRepository.delete(product);
        return product;
    }

}
