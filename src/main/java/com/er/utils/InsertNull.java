package com.er.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertNull extends Thread{
    @Override
    @Test
    public void run() {
        System.out.println(100);
        //获取Connection
        Connection conn = JDBCSource.getConn();
        //sql
        String sql = "select * from employee;";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String sql1 = "insert into dakainfo(eid) values (?)";
                preparedStatement = conn.prepareStatement(sql1);
                preparedStatement.setInt(1,resultSet.getInt(1));
                int flag = preparedStatement.executeUpdate();
                if(flag == 1){
                    System.out.println("添加成功");
                }else{
                    System.out.println("添加失败");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
