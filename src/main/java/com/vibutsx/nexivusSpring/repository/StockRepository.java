package com.vibutsx.nexivusSpring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vibutsx.nexivusSpring.entity.ItemEntity;
import com.vibutsx.nexivusSpring.entity.StockEntity;



@Repository
public interface StockRepository extends JpaRepository<StockEntity,Long> {
    Optional<StockEntity> findByItem(ItemEntity item);
}
