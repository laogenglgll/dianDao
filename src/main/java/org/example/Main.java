package org.example;

import com.er.dao.DaKaInfoDao;
import com.er.dao.EmployeeDao;
import com.er.entity.DaKaInfo;
import com.er.entity.Employee;
import com.er.utils.InsertNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println(1);
        // 创建ScheduledThreadPool，参数为线程池的大小
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        // 延迟2秒后执行任务，并且每隔3秒执行一次 86400
        scheduledThreadPool.scheduleAtFixedRate(new InsertNull(), 0, 86400, TimeUnit.SECONDS);
        //主界面
        System.out.println("-----员工签到系统-----");
        System.out.println("1---添加员工\t2---查询所有员工\t3---根据员工id删除员工\t" +
                "4---根据员工姓名删除员工\t5---签到\t6---根据id查询签到情况\t7---签退\t8---查询所有打卡信息");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请选择功能");
            int i = scanner.nextInt();
            EmployeeDao employeeDao = new EmployeeDao();
            DaKaInfoDao daKaInfoDao = new DaKaInfoDao();
            if (scanner.nextLine() != "\n") {
            }
            switch (i){
                case 1:
                    System.out.println("请输入新加入员工姓名,完成请回车");
                    String name = scanner.nextLine();
                    Employee user = new Employee(name);
                    employeeDao.addEmployee(user);
                    break;
                case 2:
                    employeeDao.getAllEmployee();
                    break;
                case 3:
                    System.out.println("请输入要删员工的id");
                    int id = scanner.nextInt();
                    employeeDao.deleteEmployeeId(id);
                    break;
                case 4:
                    System.out.println("请输入要删除的员工的名称");
                    String name4 = scanner.nextLine();
                    employeeDao.deleteEmployeeName(name4);
                    break;
                case 5:
                    Date dateTime = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
                    String format = sdf.format(dateTime);
                    System.out.println("请输入id");
                    int id5 = scanner.nextInt();
                    daKaInfoDao.getDaKa(id5,format);
                    break;
                case 6:
                    System.out.println("请输入id");
                    int id6 = scanner.nextInt();
                    DaKaInfo dakaById = daKaInfoDao.getDakaById(id6);
                    System.out.println(dakaById);
                    break;
                case  7:
                    System.out.println("请输入id");
                     id6 = scanner.nextInt();
                    daKaInfoDao.update(id6);
                    break;
                case 8:
                    daKaInfoDao.getAll();
                    break;
                default:
                    System.out.println("请输入正确的数字");
            }
        }
        //关闭线程池
        //scheduledThreadPool.shutdown();
    }
}