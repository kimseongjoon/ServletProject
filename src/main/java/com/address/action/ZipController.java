package com.address.action;

import com.address.model.ZipcodeDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/address/zipCheck")
public class ZipController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("zipCheck.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String dong = req.getParameter("dong");
        SAddressDAO dao = SAddressDAOImpl.getInstance();
        ArrayList<ZipcodeDTO> zarr = dao.getZipcodeRead(dong);

        JSONArray jarr = new JSONArray();
        for (ZipcodeDTO zd : zarr) {
            JSONObject obj = new JSONObject();

            obj.put("zipcode", zd.getZipcode());
            obj.put("sido", zd.getSido());
            obj.put("gugun", zd.getGugun());
            obj.put("dong", zd.getDong());
            obj.put("bunji", zd.getBunji());

            jarr.add(obj);
        }

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(jarr.toString());

    }
}
