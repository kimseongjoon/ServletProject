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

@WebServlet("/address/searchList")
public class SearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<AddressDTO> arr;

        req.setCharacterEncoding("utf-8");
        String field = req.getParameter("field");
        String word = req.getParameter("word");

        SAddressDAO dao = SAddressDAOImpl.getInstance();
        arr = dao.getAddressSearch(field, word);
//        int count = dao.getSearchCount(field, word);
        int count = arr.size();

        req.setAttribute("lists", arr);
        req.setAttribute("count", count);

        RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
