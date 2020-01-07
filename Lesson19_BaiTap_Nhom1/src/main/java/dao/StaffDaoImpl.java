/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionManager;
import connection.ConnectionManagerImpl;
import entities.Staff;
import entities.Title;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SMILE ^^
 */
public class StaffDaoImpl implements StaffDao {

    private Connection connection;
    private final ConnectionManager connectionManager;
    private PreparedStatement pst;
    private ResultSet rs;

    public StaffDaoImpl() {
        connectionManager = new ConnectionManagerImpl();
    }

    @Override
    public Staff getStaff(String username, String password) {
        connection = connectionManager.getConnection();
        Staff staff = null;
        String query = "SELECT * FROM java06_shopping.nhanvien WHERE TaiKhoan=?\n" + "AND MatKhau=?";
        try {
            pst = connection.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                staff = new Staff(rs.getInt("MaNV"), rs.getString("TenNV"), rs.getString("SĐT"), rs.getString("DiaChi"), rs.getString("Email"), LocalDate.parse(rs.getString("NgaySinh")), rs.getString("TaiKhoan"), rs.getString("MatKhau"), new Title(rs.getInt("MaPB"), ""));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                pst.close();
                connection.close();
            } catch (SQLException e) {
            }
        }
        return staff;
    }

}
