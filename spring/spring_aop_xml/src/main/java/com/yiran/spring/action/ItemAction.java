package com.yiran.spring.action;

import com.yiran.spring.service.ItemService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ItemAction {
    @Resource
    private ItemService itemService;

    public void addItem() {
        System.out.println("ItemAction--addItem");
        itemService.addItem();
    }

    public void updateItem() {
        System.out.println("ItemAction--updateItem");
        itemService.updateItem();
    }

    public void deleteItem() {
        System.out.println("ItemAction--deleteItem");
        itemService.deleteItem();
    }

    public void queryItem() {
        System.out.println("ItemAction--queryItem");
        itemService.queryItem();
    }
}
