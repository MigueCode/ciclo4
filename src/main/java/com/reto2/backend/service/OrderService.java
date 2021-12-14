package com.reto2.backend.service;

import com.reto2.backend.model.Order;
import com.reto2.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order){
        if (order.getId() == null){
            return order;
        }
        return orderRepository.save(order);
    }

    public List<Order> getAll(){
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(Integer id){
        return orderRepository.getOrder(id);
    }

    public List<Order> getOrdersByZone(String zone){
        return orderRepository.getOrdersByZone(zone);
    }

    public Order update(Order order){
        if (order.getId() == null){
            return order;
        }

        Optional<Order> orderAux = orderRepository.getOrder(order.getId());

        if (orderAux.isEmpty()){
            return order;
        }

        if (order.getId() == null || order.getRegisterDay() == null || order.getStatus() == null
                || order.getSalesMan() == null
                || order.getProducts() == null
                || order.getQuantities() == null){
            return order;
        }

        orderAux.get().setId(order.getId());
        orderAux.get().setRegisterDay(order.getRegisterDay());
        orderAux.get().setStatus(order.getStatus());
        orderAux.get().setSalesMan(order.getSalesMan());
        orderAux.get().setProducts(order.getProducts());
        orderAux.get().setQuantities(order.getQuantities());


        return orderRepository.update(orderAux.get());
    }
}
