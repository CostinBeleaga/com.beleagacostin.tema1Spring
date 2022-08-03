package com.clouldschool.tema1Spring.Service;

import com.clouldschool.tema1Spring.Model.Orders;
import com.clouldschool.tema1Spring.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {

    @Autowired
    OrderRepository orderRepository;

    List<Orders> list = new ArrayList<>();

    public List<Orders> getAllOrders() {
        List<Orders> aux = new ArrayList<>();
        orderRepository.findAll().iterator().forEachRemaining(aux::add);
        return aux;
    }

    public Orders getOrdersById (int ordersid)
    {
        Orders orders = orderRepository.findById(ordersid).get();
        return orders;
    }

    public Orders insertOrders (Orders orders)
    {
        Orders o = orderRepository.save(orders);
        return o;
    }
    public Orders updateOrdersById(int ordersid, Orders orders)
    {
        Orders o = orderRepository.findById(ordersid).get();
        if (orders.getStatus() != null)
            o.setStatus(orders.getStatus());
        if (orders.getComments() != null)
            o.setComments(orders.getComments());
        orderRepository.save(o);
        return o;
    }

    public Orders deleteOrdersById(int ordersid)
    {
        Orders orders = orderRepository.findById(ordersid).get();
        orderRepository.delete(orders);
        return orders;
    }

}
