package com.address.action;

import com.address.model.AddressDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/address/update")
public class updateController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        AddressDTO ad = new AddressDTO();
        int num = Integer.parseInt(req.getParameter("num"));
        ad.setNum(num);
        ad.setTel(req.getParameter("tel"));
        ad.setZipcode(req.getParameter("zipcode"));
        ad.setAddr(req.getParameter("addr"));
        ad.setName(req.getParameter("name"));

        SAddressDAO dao = SAddressDAOImpl.getInstance();
        dao.addrUpdate(ad);

        resp.sendRedirect("list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
