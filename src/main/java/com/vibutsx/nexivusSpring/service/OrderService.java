package com.vibutsx.nexivusSpring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vibutsx.nexivusSpring.entity.OrderEntity;

@Service
public interface OrderService {
    List<OrderEntity> getAll();
    OrderEntity create(OrderEntity entity);
}
