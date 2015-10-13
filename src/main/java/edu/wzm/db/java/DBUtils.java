package edu.wzm.db.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by GatsbyNewton on 2015/10/12.
 */
public class DBUtils {

    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "admin";

    static {
        try{
            Class.forName(driver);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection()throws Exception{
        return DriverManager.getConnection(url, username, password);
    }

    public static void close(ResultSet rs){
        try{
            if(!rs.isClosed() || rs != null){
                rs.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement pstm){
        try {
            if(!pstm.isClosed() || pstm != null){
                pstm.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void close(Connection conn){
        try {
            if(!conn.isClosed() || conn != null){
                conn.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}