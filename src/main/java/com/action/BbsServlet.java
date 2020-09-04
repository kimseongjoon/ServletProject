package com.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/exam/bbs")
public class BbsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String subject = req.getParameter("subject");
        String memo = req.getParameter("memo");

        req.setAttribute("name", name);
        req.setAttribute("subject", subject);
        req.setAttribute("memo", memo);

        RequestDispatcher rd = req.getRequestDispatcher("bbsResult.jsp");
        rd.forward(req, resp);

/*        resp.setContentType("text/html;charset=utf-8");
//        ServletOutputStream out = resp.getOutputStream();
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<body>");
        out.println("<b>name : " + name + "</b><br>");
        out.println("<b>subject : " + subject + "</b><br>");
        out.println("<b>memo : " + memo + "</b>");
        out.println("</body>");
        out.println("</head>");
        out.println("</html>");*/
    }
}
