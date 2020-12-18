package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }


    public void createUsersTable() {
        Connection newConnect = new Util().getConnection();
        String queryCreateUser = "create table if not exists USER ( id int primary key auto_increment,   name varchar(200) null," +
                "    lastName varchar(200) null,    age int null )";

        try {
            Statement statCreUs = newConnect.createStatement();
            statCreUs.executeUpdate(queryCreateUser);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                newConnect.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public void dropUsersTable() {
        Connection newConnect = new Util().getConnection();
        String dropUsersTable = "drop table if exists USER";

        try {
            Statement statCreUs = newConnect.createStatement();
            statCreUs.executeUpdate(dropUsersTable);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                newConnect.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        Connection newConnect = new Util().getConnection();

        String dropUsersTable = "insert into user (name,lastName,age ) values (\'" + name + "\',\'" + lastName + "\',\'" + age + "\')";

        try {
            Statement statCreUs = newConnect.createStatement();
            statCreUs.executeUpdate(dropUsersTable);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                newConnect.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void removeUserById(long id) {
        Connection newConnect = new Util().getConnection();
        String dropUsersTable = "delete from user where id = \'" + id + "\'";

        try {
            Statement statCreUs = newConnect.createStatement();
            statCreUs.executeUpdate(dropUsersTable);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                newConnect.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public List<User> getAllUsers() {  //////////////////////////
        Connection newConnect = new Util().getConnection();
        String dropUsersTable = "select * from user";

        List<User> listUserov = new ArrayList<>();

        try {
            Statement statCreUs = newConnect.createStatement();
            ResultSet resultSet = statCreUs.executeQuery(dropUsersTable);

            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                int age = resultSet.getInt(4);

                User newUser = new User (name, lastName, (byte) age);
                newUser.setId((long)id);
                listUserov.add(newUser);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                newConnect.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


        return listUserov;
    }

    public void cleanUsersTable() {
        Connection newConnect = new Util().getConnection();
        String dropUsersTable = "delete from user ";

        try {
            Statement statCreUs = newConnect.createStatement();
            System.out.println("888888 коннект установлен");
            statCreUs.executeUpdate(dropUsersTable);
            System.out.println("888888 попробовали дропнуть");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                newConnect.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
