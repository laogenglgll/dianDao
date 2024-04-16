package com.er.utils;

import java.sql.*;

public class JDBCSource {
    private static final String url = "jdbc:mysql://127.0.0.1:3309/firm2?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8";
    private static final String use = "root";
    private static final String passWord = "root";
    public static Connection conn;

    public static Connection getConn(){

        try {
            //加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接数据库
            conn = DriverManager.getConnection(url, use, passWord);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void connClose(Connection conn, PreparedStatement preparedStatement, ResultSet resultSet){
        try {
            //关闭连接
            resultSet.close();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
