package jm.task.core.jdbc;
//кря кря
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl sdf = new UserDaoJDBCImpl();

        //sdf.dropUsersTable();

        sdf.createUsersTable();
        String name1 = "vays1";
        String name2 = "vays2";
        String name3 = "vays3";
        String name4 = "vays4";
        sdf.saveUser(name1,"asfasf", (byte) 23);
        System.out.println("User с именем – " + name1 + " добавлен в базу данных");
        sdf.saveUser(name2,"sddgs", (byte) 77);
        System.out.println("User с именем – " + name2 + " добавлен в базу данных");
        sdf.saveUser(name3,"shree", (byte) 8);
        System.out.println("User с именем – " + name3 + " добавлен в базу данных");
        sdf.saveUser(name4,"asfasf", (byte) 23);
        System.out.println("User с именем – " + name4 + " добавлен в базу данных");
        List<User> sddsgs = sdf.getAllUsers();
        System.out.println(sddsgs.toString()); //должен быть переопределен toString в классе User
        sdf.dropUsersTable();
    }
}
