package jm.task.core.jdbc.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Util {

    String db = "jdbc:mysql://localhost:3306/new_db?useSSL=false&serverTimezone=UTC";
    String user = "root";
    String pass = "qweQwe52";

    Connection connection;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(db, user, pass);

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }


   /* Statement w;

    {
        try {
            w = connection.createStatement();
            w.execute("CREATE TABLE IF NOT EXISTS QQQ (QWE CHAR NULL)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
*/


    // реализуйте настройку соеденения с БД
}
