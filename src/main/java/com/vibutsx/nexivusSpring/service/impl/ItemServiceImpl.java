package com.vibutsx.nexivusSpring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vibutsx.nexivusSpring.entity.ItemEntity;
import com.vibutsx.nexivusSpring.repository.ItemRepository;
import com.vibutsx.nexivusSpring.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ItemEntity createItem(ItemEntity entity) {
       return itemRepository.save(entity);
    }

    @Override
    public List<ItemEntity> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public ItemEntity getById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public ItemEntity update(Long id,ItemEntity entity) {
        ItemEntity existingItem = getById(id);

        if(existingItem == null){
            return null;
        } else{
            existingItem.setName(entity.getName());
            existingItem.setDescription(entity.getDescription());
            existingItem.setPrice(entity.getPrice());
            existingItem.setCategory(entity.getCategory());

            return itemRepository.save(existingItem);
        }
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
    
}
