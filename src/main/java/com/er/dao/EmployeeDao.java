package com.er.dao;

import com.er.entity.Employee;
import com.er.utils.JDBCSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    /**
     * 根据员工名称删除
     * @param name
     */
    public void deleteEmployeeName(String name){
        //获取Connection
        Connection conn = JDBCSource.getConn();
        //sql
        String sql = "delete from employee where ename = ?;";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //设置？参数
            preparedStatement.setString(1,name);
            int flag = preparedStatement.executeUpdate();
            if(flag == 1){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据id删除员工
     * @param id
     */
    public void deleteEmployeeId(int id){
        //获取Connection
        Connection conn = JDBCSource.getConn();
        //sql
        String sql = "delete from employee where id = ?;";
        try {
            PreparedStatement preparedStatement =  conn.prepareStatement(sql);
            //设置？参数
            preparedStatement.setInt(1,id);
            int flag = preparedStatement.executeUpdate();
            if(flag == 1){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询所有员工
     * @return
     */
    public void getAllEmployee(){
        //获取Connection
        Connection conn = JDBCSource.getConn();
        //sql
        String sql  = "select * from employee;";
        try {
            PreparedStatement preparedStatement =  conn.prepareStatement(sql);
            //执行sql
            ResultSet resultSet =  preparedStatement.executeQuery();
            while(resultSet.next()){
                Employee ob = new Employee();
                ob.setId(resultSet.getInt(1));
                ob.setEname(resultSet.getString(2));
                System.out.println(ob);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 添加员工
     * @param user
     */
    public void addEmployee(Employee user){
        //获取Connection
        Connection conn = JDBCSource.getConn();
        //sql
        String sql  = "insert into employee values(null,?);";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //设置？参数
            preparedStatement.setString(1, user.getEname());
            int flag = preparedStatement.executeUpdate();
            if(flag == 1){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
