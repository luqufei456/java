package com.yiran.spring.service.impl;

import com.yiran.spring.dao.ItemDao;
import com.yiran.spring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    @Override
    public void addItem() {
        System.out.println("ItemService--addItem");
        itemDao.addItem();
    }

    @Override
    public void updateItem() {
        System.out.println("ItemService--updateItem");
        itemDao.updateItem();
        throw new RuntimeException();
    }

    @Override
    public void deleteItem() {
        System.out.println("ItemService--deleteItem");
        itemDao.deleteItem();
    }

    @Override
    public void queryItem() {
        System.out.println("ItemService--queryItem");
        itemDao.queryItem();
    }

}
