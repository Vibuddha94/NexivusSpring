package com.vibutsx.nexivusSpring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.vibutsx.nexivusSpring.dto.StockDto;
import com.vibutsx.nexivusSpring.entity.StockEntity;
import com.vibutsx.nexivusSpring.service.ItemService;
import com.vibutsx.nexivusSpring.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/stock")
    public ResponseEntity<List<StockEntity>> getAll() {
        List<StockEntity> stock = stockService.getAll();

        return ResponseEntity.status(200).body(stock);
    }

    @PostMapping("/stock")
    public ResponseEntity<StockEntity> create(@RequestBody StockDto dto) {

        StockEntity newStock = new StockEntity();

        if (itemService.getById(dto.getItemId()) == null) {
            return ResponseEntity.status(404).body(null);
        } else {
            newStock.setItem(itemService.getById(dto.getItemId()));
            newStock.setQoh(dto.getQty());

            if (stockService.getByItem(newStock.getItem()) == null) {
                StockEntity createdStock = stockService.create(newStock);
                return ResponseEntity.status(201).body(createdStock);
            } else {
                return ResponseEntity.status(403).body(null);
            }
        }
    }

    @PutMapping("stock/addto")
    public ResponseEntity<List<StockEntity>> addToStock(@RequestBody List<StockDto> dtos) {
        List<StockEntity> updatedList = new ArrayList<>();
        for (StockDto stockDto : dtos) {
            StockEntity updated = stockService.addToStock(stockDto.getItemId(), stockDto.getQty());
            if (updated != null) {
                updatedList.add(updated);
            } 
        }
        return ResponseEntity.status(201).body(updatedList);
    }

    @PutMapping("stock/getfrom")
    public ResponseEntity<List<StockEntity>> getFromStock(@RequestBody List<StockDto> dtos) {
        List<StockEntity> updatedList = new ArrayList<>();
        for (StockDto stockDto : dtos) {
            StockEntity updated = stockService.getFromStock(stockDto.getItemId(), stockDto.getQty());
            if (updated != null) {
                updatedList.add(updated);
            } 
        }
        return ResponseEntity.status(201).body(updatedList);
    }
}
