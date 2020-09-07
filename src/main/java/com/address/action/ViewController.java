package com.address.action;

import com.address.model.AddressDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/address/view")
public class ViewController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int num = Integer.parseInt(req.getParameter("num"));

        SAddressDAO dao = SAddressDAOImpl.getInstance();
        AddressDTO ad = dao.getAddressView(num);

//        System.out.println(ad.getName());
//        System.out.println(ad.getAddr()); //printstream 확인 필요

        /*req.setAttribute("name", ad.getName());
        req.setAttribute("addr", ad.getAddr());
        req.setAttribute("phone", ad.getTel());
        req.setAttribute("zipcode", ad.getZipcode());*/

        req.setAttribute("address", ad);
        RequestDispatcher rd = req.getRequestDispatcher("view.jsp");
        rd.forward(req, resp);
    }
}
