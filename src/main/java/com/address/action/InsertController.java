package com.address.action;

import com.address.model.AddressDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/address/insert")
public class InsertController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String name = req.getParameter("name");
        String zipcode = req.getParameter("zipcode");
        String addr = req.getParameter("addr");
        String tel = req.getParameter("tel");

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setName(name);
        addressDTO.setZipcode(zipcode);
        addressDTO.setAddr(addr);
        addressDTO.setTel(tel);

        SAddressDAO dao = SAddressDAOImpl.getInstance();
        dao.addrInsert(addressDTO);

        resp.sendRedirect("list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
        rd.forward(req, resp);
    }
}
