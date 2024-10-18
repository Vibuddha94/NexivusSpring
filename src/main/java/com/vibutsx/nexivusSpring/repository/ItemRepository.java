package com.vibutsx.nexivusSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vibutsx.nexivusSpring.entity.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity,Long>{
     
}
