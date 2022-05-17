package com.huangmaohua.controller;

import com.huangmaohua.dao.ProductDao;
import com.huangmaohua.model.Category;
import com.huangmaohua.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="ShopServlet",value = "/shop")
public class ShopServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Category category = new Category();
        List<Category> categoryList = null;
        try {
            categoryList = category.findAllCategory(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("categoryList",categoryList);

        ProductDao productDao = new ProductDao();
        try {
            if (req.getParameter("categoryId") == null) {
                List<Product> productList = productDao.findAll(con);
                req.setAttribute("productList", productList);
            } else {
                int catId = Integer.parseInt(req.getParameter("categoryId"));
                productDao.findByCategoryId(catId, con);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        String path = "/WEB-INF/views/shop.jsp";
        req.getRequestDispatcher(path).forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
