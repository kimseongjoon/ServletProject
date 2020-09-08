package com.address.action;

import com.address.model.AddressDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/address/searchList")
public class SearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String field = req.getParameter("field");
        String word = req.getParameter("word");

        SAddressDAO dao = SAddressDAOImpl.getInstance();
        ArrayList<AddressDTO> arr = dao.getAddressSearch(field, word);
        int count = dao.getSearchCount(field, word);

        JSONArray jarr = new JSONArray();

        for (AddressDTO dto : arr) {
            JSONObject obj = new JSONObject();

            obj.put("num", dto.getNum());
            obj.put("name", dto.getName());
            obj.put("tel", dto.getTel());
            obj.put("addr", dto.getAddr());
            obj.put("zipcode", dto.getZipcode());

            jarr.add(obj);
        }

        JSONObject countObj = new JSONObject();
        countObj.put("count", count);

        JSONObject mainObj = new JSONObject();
        mainObj.put("jarr", jarr);
        mainObj.put("countObj", countObj);

        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();
        out.println(mainObj.toString());

       /* req.setAttribute("lists", arr);
        req.setAttribute("count", count);

        RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
        rd.forward(req, resp);*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
