package com.yiran.dao.impl;

import com.yiran.dao.ItemDAO;
import com.yiran.domain.Item;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public String addItem(Item item) {
        return item.getName();
    }

    @Override
    public Item queryItemById(int id) {
        return null;
    }
}
