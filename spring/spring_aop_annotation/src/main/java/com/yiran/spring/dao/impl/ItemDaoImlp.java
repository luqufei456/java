package com.yiran.spring.dao.impl;

import com.yiran.spring.dao.ItemDao;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDaoImlp implements ItemDao {

    @Override
    public void addItem() {
        System.out.println("ItemDao--addItem");
    }

    @Override
    public void updateItem() {
        System.out.println("ItemDao--updateItem");
    }

    @Override
    public void deleteItem() {
        System.out.println("ItemDao--deleteItem");
    }

    @Override
    public void queryItem() {
        System.out.println("ItemDao--queryItem");
    }
}
