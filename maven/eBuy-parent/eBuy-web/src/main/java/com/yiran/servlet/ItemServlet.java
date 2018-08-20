package com.yiran.servlet;

import com.yiran.domain.Item;
import com.yiran.service.ItemService;
import com.yiran.service.impl.ItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ItemServlet",value = "/ItemServlet")
public class ItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        ItemService itemService = new ItemServiceImpl();
        int itemId = Integer.parseInt(request.getParameter("id"));
        Item item = new Item();
        item.setId(itemId);
        item.setName("aa");

        System.out.println(new String[0]);

        String name = itemService.addItem(item);
        if (name.equals("bb")){
            System.out.println("失败");
        }
        else {
            System.out.println("成功");
        }
        response.getWriter().write("他的名字是"+name);
    }
}
