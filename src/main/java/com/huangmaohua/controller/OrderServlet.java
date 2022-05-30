package com.huangmaohua.controller;

import com.huangmaohua.dao.OrderDao;
import com.huangmaohua.model.Item;
import com.huangmaohua.model.Order;
import com.huangmaohua.model.Payment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@WebServlet(name="OrderServlet",value = "/order")
public class OrderServlet extends HttpServlet {

    Connection con = null;

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Payment> paymentTypeList=Payment.findAllPayment(con);
        req.setAttribute("paymentTypeList",paymentTypeList);
        String path = "/WEB-INF/views/order.jsp";
        req.getRequestDispatcher(path).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int customerId=req.getParameter("customerId")!=null?Integer.parseInt(req.getParameter("customerId")):0;
        int paymentId=req.getParameter("paymentId")!=null?Integer.parseInt(req.getParameter("paymentId")):0;
        String firstName=req.getParameter("firstName");
        String lastName=req.getParameter("lastName");
        String phone=req.getParameter("phone");
        String address1=req.getParameter("address1");
        String address2=req.getParameter("address2");
        String postalCode=req.getParameter("postalCode");
        String state=req.getParameter("state");
        String country=req.getParameter("country");
        String city=req.getParameter("city");
        String notes=req.getParameter("notes");
        double orderTotal=req.getParameter("orderTotal")!=null?Double.parseDouble(req.getParameter("orderTotal")):0.0;

        String message= null;
        if(customerId==0||paymentId==0||firstName==null||firstName.trim().length()==0||phone==null|| phone.trim().length()==0||address1==null||address1.trim().length()==0||postalCode==null||postalCode.trim().length()==0){
            message="ERROR!,Enter Required(*)Info.";
            req.setAttribute("message",message);
            List<Payment> paymentTypeList=Payment.findAllPayment(con);
            req.setAttribute("paymentTypeList",paymentTypeList);
            String path="/WEB-INF/views/order.jsp";
            req.getRequestDispatcher(path).forward(req,resp);
        }
        Order o=new Order();
        o.setCustomerId(customerId);
        o.setPaymentId(paymentId);
        o.setFirstName(firstName);
        o.setLastName(lastName);
        o.setPhone(phone);
        o.setAddress1(address1);
        o.setAddress2(address2);
        o.setCity(city);
        o.setCountry(country);
        o.setState(state);
        o.setNotes(notes);
        o.setPostalCode(postalCode);
        o.setOrderTotal(orderTotal);
        HttpSession session=req.getSession(false);
        if(session!=null&&session.getAttribute("cart")!=null){
            ArrayList<Item> cartItems=(ArrayList<Item>) session.getAttribute("cart");
            o.setOrderDetails(new HashSet<Item>(cartItems));
        }
        OrderDao dao = new OrderDao();
        int n=0;
        try {
            n=dao.save(con,o);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(n>0){
            String path="/WEB-INF/views/orderSuccess.jsp";
            req.getRequestDispatcher(path.formatted(req,resp));

        }
    }



}
