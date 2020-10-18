/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonout.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author JuanJose
 */
public class Database {
    static String hostname = "localhost";//"173.243.120.230";//"localhost";
    static String port = "3306";
    static String database = "solution_hackbbvacarbonout";//"solution_hackbbvacarbonout";
    static String username = "solution_admin";//"solution_admin"; //root
    static String password = "mydb123.2020";//"mydb123.2020";   //root
    static String databaseVendor = "MySQL";
    
    private static  DataSource ds;
    
    public Database() {
    }
    
    public static Connection getConnection() throws SQLException {
        switch (databaseVendor) {
            case "MySQL":
                return getConnectionMySQL();
            case "Oracle":
                return getConnectionOracle();
            default:
                return null;
        }
    }
        
    public static Connection getConnectionOracle() throws SQLException {
        Connection conn;        
        String jdbcUrl = "jdbc:oracle:thin:@" + hostname + ":"
                + port + ":" + database;
        conn = DriverManager.getConnection(jdbcUrl, username, password);
         System.out.println("Conexion con exito!");
        return conn;
    }
    
    public static Connection getConnectionMySQL() throws SQLException {
        Connection conn;
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
        }   
        
        String jdbcUrl = "jdbc:mysql://" + hostname + ":" + 
                        port  + "/" + database + "?useInformationSchema=true"; 
                        //+"&useSSL=false" 
                        //+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
                        //"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        conn = DriverManager.getConnection(jdbcUrl, username, password);//, username, password);
        System.out.println("Conexion exito!");
        return conn;
    }
}
