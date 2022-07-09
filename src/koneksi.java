/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class koneksi {
    //jdbc:jenisdatabaseserver://alamatdatabase:portdatabase//namadatabase
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/chatting";
    static final String USER = "root";
    static final String PASSWORD = "";
    
    static Connection connection;
    static Statement statement;
    
    public void config(){
        try {
            connection = DriverManager.getConnection(JDBC_URL,USER,PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
