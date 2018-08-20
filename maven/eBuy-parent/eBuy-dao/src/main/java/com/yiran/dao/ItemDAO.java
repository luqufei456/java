package com.yiran.dao;

import com.yiran.domain.Item;

public interface ItemDAO {
    String addItem(Item item);

    Item queryItemById(int id);

}
