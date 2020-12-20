package jm.task.core.jdbc;
//кря кря
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userJDBC = new UserDaoJDBCImpl();

        //sdf.dropUsersTable();

        userJDBC.createUsersTable();
        String name1 = "vays1";
        String name2 = "vays2";
        String name3 = "vays3";
        String name4 = "vays4";
        userJDBC.saveUser(name1,"asfasf", (byte) 23);
        System.out.println("User с именем – " + name1 + " добавлен в базу данных");
        userJDBC.saveUser(name2,"sddgs", (byte) 77);
        System.out.println("User с именем – " + name2 + " добавлен в базу данных");
        userJDBC.saveUser(name3,"shree", (byte) 8);
        System.out.println("User с именем – " + name3 + " добавлен в базу данных");
        userJDBC.saveUser(name4,"asfasf", (byte) 23);
        System.out.println("User с именем – " + name4 + " добавлен в базу данных");
        List<User> listUserJDBC = userJDBC.getAllUsers();
        System.out.println(listUserJDBC.toString()); //должен быть переопределен toString в классе User
       // sdf.dropUsersTable();

        UserDaoHibernateImpl userHibernate = new UserDaoHibernateImpl();
        userHibernate.saveUser("QQQQQQQQQQQQQQQQQQ","WWWWWWWWWWWWWWWW", (byte) 999);
        List<User> listUserHibernate = userHibernate.getAllUsers();
        System.out.println(listUserHibernate.toString());


    }
}
