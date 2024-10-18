package com.vibutsx.nexivusSpring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vibutsx.nexivusSpring.entity.OrderEntity;
import com.vibutsx.nexivusSpring.repository.OrderRepository;
import com.vibutsx.nexivusSpring.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderEntity> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderEntity create(OrderEntity entity) {
        return orderRepository.save(entity);
    }
    
}
