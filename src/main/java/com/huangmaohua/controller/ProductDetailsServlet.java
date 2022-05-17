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

@WebServlet("/productDetails")
public class ProductDetailsServlet extends HttpServlet {
    private Connection con = null;
    public void init() throws SecurityException{
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =req.getParameter("id")!=null?Integer.parseInt(req.getParameter("id")):0;
        ProductDao productDao = new ProductDao();
        if(id==0){
            return;
        }
        List<Category> categoryList= null;
        try {
            categoryList = Category.findAllCategory(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("categoryList",categoryList);

        Product product = productDao.findById(id,con);
        req.setAttribute("p",product);
        String path ="/WEB-INF/views/productDetails.jsp";
        req.getRequestDispatcher(path).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
