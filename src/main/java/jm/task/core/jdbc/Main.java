package jm.task.core.jdbc;
//кря кря
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;


public class Main {
    public static void main(String[] args) {
       /* UserDaoJDBCImpl userJDBC = new UserDaoJDBCImpl();
       // userJDBC.dropUsersTable();
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

        */

        //UserDaoHibernateImpl dropTable = new UserDaoHibernateImpl();
        //dropTable.dropUsersTable();

        String name1 = "vays1";
        String name2 = "vays2";
        String name3 = "vays3";
        String name4 = "vays4";

        UserDaoHibernateImpl reateTable = new UserDaoHibernateImpl();
        reateTable.createUsersTable();

        UserDaoHibernateImpl userHibernate = new UserDaoHibernateImpl();
        userHibernate.saveUser(name1,"dsfsdf", (byte) 7775);
        System.out.println("User с именем – " + name1 +" добавлен в базу данных");
        UserDaoHibernateImpl userHibernate2 = new UserDaoHibernateImpl();
        userHibernate.saveUser(name2,"jkghkgh", (byte) 3333333);
        System.out.println("User с именем – " + name2 +" добавлен в базу данных");
        UserDaoHibernateImpl userHibernate3 = new UserDaoHibernateImpl();
        userHibernate.saveUser(name3,"iuiul", (byte) 2);
        System.out.println("User с именем – " + name3 +" добавлен в базу данных");
        UserDaoHibernateImpl userHibernate4 = new UserDaoHibernateImpl();
        userHibernate.saveUser(name4,"qqqqqq", (byte) 1);
        System.out.println("User с именем – " + name4 +" добавлен в базу данных");

        List<User> listUserHibernate = userHibernate.getAllUsers();
        System.out.println(listUserHibernate.toString());
        System.out.println("___________________");

        //ystem.out.println(userHibernate.findById(2).toString());

        UserDaoHibernateImpl clean = new UserDaoHibernateImpl();
        clean.cleanUsersTable();
        System.out.println("Таблица очищена");

        UserDaoHibernateImpl delete = new UserDaoHibernateImpl();
        delete.dropUsersTable();
        System.out.println("таблица удалена");
    }
}
