package com.yiran.service;

import com.yiran.domain.Item;

public interface ItemService {
    String addItem(Item item);

    Item queryItemById(int id);
}
