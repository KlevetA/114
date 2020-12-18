package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
        UserDaoJDBCImpl d = new UserDaoJDBCImpl();
        d.createUsersTable();
    }

    public void dropUsersTable() {
        UserDaoJDBCImpl d = new UserDaoJDBCImpl();
        d.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        UserDaoJDBCImpl d = new UserDaoJDBCImpl();
        d.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {
        UserDaoJDBCImpl d = new UserDaoJDBCImpl();
        d.removeUserById(id);
    }

    public List<User> getAllUsers() {
        UserDaoJDBCImpl d = new UserDaoJDBCImpl();
        return d.getAllUsers();
    }

    public void cleanUsersTable() {
        UserDaoJDBCImpl d = new UserDaoJDBCImpl();
        d.cleanUsersTable();
    }
}
