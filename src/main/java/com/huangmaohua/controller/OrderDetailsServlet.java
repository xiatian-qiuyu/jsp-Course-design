package com.huangmaohua.controller;

import com.huangmaohua.dao.OrderDao;
import com.huangmaohua.model.Item;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/orderDetails")
public class OrderDetailsServlet extends HttpServlet {
    private Connection con = null;

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    public void destroy() {
        super.destroy();
        Logger logger = Logger.getLogger(String.valueOf(OrderDetailsServlet.class));
        logger.info("destroy");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int orderId = req.getParameter("orderId")!=null? Integer.parseInt(req.getParameter("orderId")) :0;
        Item item = new Item();
        OrderDao dao = new OrderDao();
        List<Item> items = dao.findItemsByOrderId(con, orderId);
        req.setAttribute("itemList",items);
        String path = "orderDetails.jsp";
        req.getRequestDispatcher(path).forward(req,resp);
    }
}