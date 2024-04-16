import com.er.dao.EmployeeDao;
import com.er.entity.Employee;

import java.util.List;
/*

 */
public class Test {
    //getAllEmployee方法测试
    @org.junit.Test
    public void getAllEmployeeTest(){
//        EmployeeDao employeeDao = new EmployeeDao();
//        List<Employee> allEmployee = employeeDao.getAllEmployee();
//        System.out.println(allEmployee);
    }
    //addEmployeeTest
    @org.junit.Test
    public void addEmployeeTest(){
        Employee ob = new Employee("裘宏宇");
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.addEmployee(ob);

    }
    @org.junit.Test
    public void test(){

    }

    @org.junit.Test
    public void Test(){
        Dog dog = new Dog();
        Cat1 cat = new Cat1();
        Game game = new Game();
        game.play(dog);
        game.play(cat);
    }


}
