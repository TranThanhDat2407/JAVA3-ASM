/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOF203_Lab5;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THANHDAT
 */
public class LAB5_BAI1 {

    private static String USERNAME = "sa";
    private static String PASSWORD = "123";
    private static String DB_URL = "jdbc:sqlserver://ThanhDat:1433;databaseName=SOF203_LAB5;encrypt=true;trustServerCertificate=true;";

    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String SQL = "SELECT * FROM STUDENTS";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            while(rs.next()){
                System.out.print(rs.getString("MaSV") + ", ");
                System.out.print(rs.getString("Hoten") + ", ");
                System.out.print(rs.getString("Email") + ", ");
                System.out.print(rs.getString("SoDT") + ", ");
                System.out.print(rs.getString("GioiTinh") + ", ");
                System.out.println(rs.getString("Diachi"));
            }
        } catch (SQLException e) {
            Logger.getLogger(LAB5_BAI1.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}
