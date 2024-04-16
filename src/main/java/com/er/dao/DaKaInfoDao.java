package com.er.dao;

import com.er.entity.DaKaInfo;
import com.er.utils.JDBCSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DaKaInfoDao {
    /**
     * 查询员工在指定日期是否打卡， 如果没有打卡，查询结果为空， 如果打过签到卡，就会返回一条打卡信息
     *
     * @param eid  员工编号
     * @param date 日期， 格式 yyyy-MM-dd
     * @return 返回对象中包含了 员工的编号，以及 员工的签到时间(可能为null)，签退时间（可能为null）
     */
    public DaKaInfo getDaKa(int eid, String date) {
        //获取Connection
        Connection conn = JDBCSource.getConn();
        //sql
        String sql = "select * from dakainfo where eid = ?;";
        //求当天的记录id
        int maxId = 0;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, eid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int anInt = resultSet.getInt(1);
                if(anInt >maxId){
                    maxId = anInt;
                }
            }
                sql = "update dakainfo set qdtime = ? where eid = ? and id = ?;";
                preparedStatement =  conn.prepareStatement(sql);
                Date dateTime = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
                String format = sdf.format(dateTime);
                preparedStatement.setString(1,format);
                preparedStatement.setInt(2,eid);
                preparedStatement.setInt(3,maxId);
                int flag = preparedStatement.executeUpdate();
                if (flag != 0) {
                    System.out.println("添加成功");
                } else {
                    System.out.println("添加失败");
                }

            if (maxId == 0){
                System.out.println("添加失败无此id");
            }
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 插入一条打卡信息，
     *
     * @param id :  参数中包括  员工编号，签到日期
     */
    public void insert(int id) {
        //获取Connection
        Connection conn = JDBCSource.getConn();
        //sql
        String sql = "select * from dakainfo where id = ?;";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                if(resultSet.getString(3) == null){
                    Date dateTime = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
                    String format = sdf.format(dateTime);
                    sql = "update dakainfo set qdtime = ?;";
                    preparedStatement  = conn.prepareStatement(sql);
                    int flag = preparedStatement.executeUpdate();
                    if (flag == 1) {
                        System.out.println("添加成功");
                    } else {
                        System.out.println("添加失败");
                    }
                    return ;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * 根据打卡表主键查询
     *
     * @param id
     */
    public DaKaInfo getDakaById(int id) {
        //获取Connection
        Connection conn = JDBCSource.getConn();
        //sql
        String sql = "select * from dakainfo where id = ?;";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                DaKaInfo daKaInfo = new DaKaInfo();
                daKaInfo.setId(resultSet.getInt(1));
                daKaInfo.setEid(resultSet.getInt(2));
                daKaInfo.setQdTime(resultSet.getString(3));
                daKaInfo.setQtTime(resultSet.getString(4));

                return daKaInfo;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * 员工签退时，会调用该方法，修改签退时间--取系统当前时间， 可以根据打卡表的主键签退， 也可以根据日期和员工编号签退
     *
     * @param id：
     */
    public void update(int id) {
        Date dateTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String format = sdf.format(dateTime);
        //获取Connection
        Connection conn = JDBCSource.getConn();
        //sql
        String sql = "update dakainfo set qttime = ? where qdtime like ? and eid = ?;";
        try {
            //获取当天的时间，进行时间的判断，来完成当天的打卡签退
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
            String format1 = sdf1.format(dateTime);
            String format2 = format1.replace("/","-");
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, format);
            preparedStatement.setString(2, format2+"%");
            preparedStatement.setInt(3,id);
            int flag = preparedStatement.executeUpdate();
            if (flag != 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * 查询所有打卡信息
     */
    public void getAll() {
        //获取Connection
        Connection conn = JDBCSource.getConn();
        //sql
        String sql = "select * from dakainfo;";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Object value = null;
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    value = resultSet.getObject(i);
                    System.out.print(value+"\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
