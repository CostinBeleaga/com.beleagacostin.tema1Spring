package com.clouldschool.tema1Spring.controllers;

import com.clouldschool.tema1Spring.Model.Product;
import com.clouldschool.tema1Spring.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products/all")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable(value="id")int productid)
    {
        return productService.getProductById(productid);
    }

    @PostMapping("/products")
    @ResponseBody
    public Product insertProduct(@RequestBody Product product)
    {
        return productService.insertProduct(product);
    }

    @PostMapping("/products/{id}")
    @ResponseBody
    public Product updateProductsById(@PathVariable(value="id")int productid,@RequestBody Product product)
    {
        return productService.updateProductsById(productid, product);
    }
    @DeleteMapping("/products/{id}")
    @ResponseBody
    public Product deleteProductById(@PathVariable(value="id")int productid)
    {
        return productService.deleteProductById(productid);
    }
}
