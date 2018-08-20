package com.yiran.service.impl;

import com.yiran.dao.ItemDAO;
import com.yiran.dao.impl.ItemDAOImpl;
import com.yiran.domain.Item;
import com.yiran.service.ItemService;

public class ItemServiceImpl implements ItemService {
    private ItemDAO itemDAO = new ItemDAOImpl();

    @Override
    public String addItem(Item item) {
        return itemDAO.addItem(item);
    }

    @Override
    public Item queryItemById(int id) {
        return itemDAO.queryItemById(id);
    }
}
