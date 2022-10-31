package com.example.dong.Jdbc;

import okhttp3.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
    public static void close(ResultSet rs) throws SQLException {
        if(rs != null && !rs.isClosed()){
            try{
                rs.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }

        }
    } // DB 프로그래밍에서의 ResultSet 객체 close 하는 메소드

    public static void close(PreparedStatement pstmt) throws SQLException{
        if(pstmt != null && !pstmt.isClosed()){
            try{
                pstmt.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    } // DB 프로그래밍에서의 PreparedStatement 객체 close 하는 메소드

    public static void close(Connection conn) throws SQLException{
        if(conn != null && !conn.isClosed()){
            try{
                conn.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    } // DB 프로그래밍에서의 Connection 객체 close 하는 메소드

    public static void close(Response response){

        if(response != null)
            response.close();
    } // OkHttp3 의 Response 객체 close 하는 메소드


    public static void rollback(Connection conn){
        if(conn != null){
            try{
                conn.rollback();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

}
