package com.clouldschool.tema1Spring.controllers;

import com.clouldschool.tema1Spring.Model.Orders;
import com.clouldschool.tema1Spring.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @GetMapping("/orders/all")
    public List<Orders> getAllOrders()
    {
        return ordersService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    @ResponseBody
    public Orders getOrdersById(@PathVariable(value="id")int ordersid)
    {
        return ordersService.getOrdersById(ordersid);
    }

    @PostMapping("/orders")
    @ResponseBody
    public Orders insertOrders(@RequestBody Orders orders)
    {
        return ordersService.insertOrders(orders);
    }

    @PostMapping("/orders/{id}")
    @ResponseBody
    public Orders updateOrdersById(@PathVariable(value="id")int ordersid,@RequestBody Orders orders)
    {
        return ordersService.updateOrdersById(ordersid, orders);
    }
    @DeleteMapping("/orders/{id}")
    @ResponseBody
    public Orders deleteOrdersById(@PathVariable(value="id")int ordersid)
    {
        return ordersService.deleteOrdersById(ordersid);
    }
}
