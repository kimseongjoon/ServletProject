package com.file;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/files/upload")
public class FilesController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String savePath = "upload";
        int uploadFileSizeLimit = 5 * 1024 * 1024;
        String encType = "utf-8";
        ServletContext context = getServletContext();
        String uploadFilePath = context.getRealPath(savePath);


        MultipartRequest multi = new MultipartRequest(
                req,
                uploadFilePath,
                uploadFileSizeLimit,
                encType,
                new DefaultFileRenamePolicy()
        );


        /*String fileName = multi.getFilesystemName("uploadFile");
        if (fileName == null) {
            System.out.println("파일 업로드 안됨");
        } else {
            FileDTO file = new FileDTO(multi.getParameter("name"), multi.getParameter("title"), fileName);
            FileDAO dao = FileDAO.getInstance();
            dao.fileInsert(file);
//            dao.fileInsert(multi.getParameter("name"), multi.getParameter("title"), fileName);
        }

        resp.sendRedirect("imageList");*/

    }
}
