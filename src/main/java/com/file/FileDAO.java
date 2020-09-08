package com.file;

import com.address.action.SAddressDAOImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class FileDAO {
    private static FileDAO instance = new FileDAO();
    public static FileDAO getInstance() {
        return instance;
    }

    private FileDAO() {
        //
    }

    private Connection getConnection() throws NamingException, SQLException {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource) envCtx.lookup("jdbc/servlet");
        return ds.getConnection();
    }

    // 이미지 추가
    public void fileInsert(String name, String title, String image) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();
            String sql = "INSERT INTO IMAGETEST VALUES(?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, title);
            ps.setString(3, image);
            ps.executeUpdate();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        closeConnection(con, ps, null, null);
    }

    // 이미지 전체보기
    public ArrayList<FileDTO> fileList() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<FileDTO> arr = new ArrayList<>();

        try {
            con = getConnection();
            String sql = "SELECT * FROM IMAGETEST";
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                FileDTO f = new FileDTO();

             /*   f.setName(rs.getString("NAME"));
                f.setTitle(rs.getString("TITLE"));
                f.setImage(rs.getString("IMAGE"));*/

                arr.add(f);
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, null, st, rs);
        }

        return arr;

    }

    private void closeConnection(Connection con, PreparedStatement ps, Statement st, ResultSet rs) {
        try {
            if (con != null) con.close();
            if (ps != null) ps.close();
            if (st != null) st.close();
            if (rs != null) rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void fileInsert(FileDTO file) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();
            String sql = "INSERT INTO IMAGETEST VALUES(?, ?, ?)";
            ps = con.prepareStatement(sql);
            /*ps.setString(1, file.getName());
            ps.setString(2, file.getTitle());
            ps.setString(3, file.getImage());*/
            ps.executeUpdate();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        closeConnection(con, ps, null, null);
    }
}
