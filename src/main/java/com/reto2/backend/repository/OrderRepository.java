package com.reto2.backend.repository;

import com.reto2.backend.model.Order;
import com.reto2.backend.repository.crud.OrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    @Autowired
    private OrderCrudRepository orderCrudRepository;

    public Order save(Order order){
        return orderCrudRepository.save(order);
    }

    public List<Order> getAll(){
        return orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(Integer id){
        return orderCrudRepository.findById(id);
    }

    public List<Order> getOrdersByZone(String zone){
        return orderCrudRepository.findBySalesManZone(zone);
    }

    public Order update(Order order){
        return orderCrudRepository.save(order);
    }
}
