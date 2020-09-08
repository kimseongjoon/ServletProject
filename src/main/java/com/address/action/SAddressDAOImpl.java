package com.address.action;

import com.address.model.AddressDTO;
import com.address.model.ZipcodeDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class SAddressDAOImpl implements SAddressDAO{
    private static SAddressDAOImpl instance = new SAddressDAOImpl();
    public static SAddressDAOImpl getInstance() {
        return instance;
    }

    private SAddressDAOImpl() {
        //
    }

    private Connection getConnection() throws NamingException, SQLException {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource) envCtx.lookup("jdbc/servlet");
        return ds.getConnection();
    }
    @Override
    public void addrInsert(AddressDTO address) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String sql = "insert into address values(ADDRESS_SEQ.NEXTVAL, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, address.getName());
            ps.setString(2, address.getTel());
            ps.setString(3, address.getZipcode());
            ps.setString(4, address.getAddr());
            ps.executeUpdate();

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, null, null);
        }
    }

    @Override
    public ArrayList<AddressDTO> getAddressList() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<AddressDTO> arr = new ArrayList<>();

        try {
            con = getConnection();
            String sql = "select * from address";
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                AddressDTO dt = new AddressDTO();
                dt.setNum(rs.getInt("num"));
                dt.setName(rs.getString("name"));
                dt.setAddr(rs.getString("addr"));
                dt.setZipcode(rs.getString("zipcode"));
                dt.setTel(rs.getString("tel"));

                arr.add(dt);
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

    @Override
    public AddressDTO getAddressView(int num) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        AddressDTO dt = null;

        try {
            con = getConnection();
            String sql = "SELECT * FROM ADDRESS WHERE NUM=" + num;
            st = con.createStatement();
            rs = st.executeQuery(sql);

            System.out.println("getAddressView -> " + sql);
            if (rs.next()) {
                dt = new AddressDTO();
                dt.setNum(num);
                dt.setName(rs.getString("name"));
                dt.setAddr(rs.getString("addr"));
                dt.setZipcode(rs.getString("zipcode"));
                dt.setTel(rs.getString("tel"));
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, null, st, rs);
        }

        return dt;
    }

    @Override
    public void addrUpdate(AddressDTO addressDTO) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConnection();

            String sql = "UPDATE ADDRESS SET NAME=?, TEL=?, ZIPCODE=?, ADDR=? WHERE NUM=" + addressDTO.getNum();

            ps = con.prepareStatement(sql);
            ps.setString(1, addressDTO.getName());
            ps.setString(2, addressDTO.getTel());
            ps.setString(3, addressDTO.getZipcode());
            ps.setString(4, addressDTO.getAddr());

            System.out.println("addrUpdate -> " + sql);
            ps.executeUpdate();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, null, null);
        }
    }

    @Override
    public void addrDelete(int num) {
        Connection con = null;
        Statement st = null;

        try {
            con = getConnection();
            st = con.createStatement();

            String sql = "DELETE FROM ADDRESS WHERE NUM=" + num;
            System.out.println("addrDelete -> " + sql);
            st.executeUpdate(sql);
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, null, st, null);
        }
    }

    @Override
    public int getCount() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        int count = 0;

        try {
            con = getConnection();
            String sql = "SELECT count(*) FROM ADDRESS";
            System.out.println("getCount -> " + sql);

            st = con.createStatement();
            rs = st.executeQuery(sql);

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, null, st, rs);
        }

        return count;
    }

    @Override
    public ArrayList<AddressDTO> getAddressSearch(String field, String word) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<AddressDTO> arr = new ArrayList<>();

        try {
            con = getConnection();
            String sql = "SELECT * FROM ADDRESS WHERE " + field + " like '%" + word + "%'";
            System.out.println("getAddressSearch -> " + sql);

            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                AddressDTO dt = new AddressDTO();
                dt.setName(rs.getString("name"));
                dt.setAddr(rs.getString("addr"));
                dt.setZipcode(rs.getString("zipcode"));
                dt.setTel(rs.getString("tel"));

                arr.add(dt);
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

    @Override
    public int getSearchCount(String field, String word) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        int count = 0;

        try {
            con = getConnection();
            String sql = "SELECT count(*) FROM ADDRESS WHERE " + field + " like '%" + word + "%'";
            System.out.println("getSearchCount -> " + sql);

            st = con.createStatement();
            rs = st.executeQuery(sql);

            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(con, null, st, rs);
        }

        return count;
    }

    @Override
    public ArrayList<ZipcodeDTO> getZipcodeRead(String dong) {
        return null;
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
}
