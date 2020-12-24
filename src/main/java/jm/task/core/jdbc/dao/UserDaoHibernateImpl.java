package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Session session =  Util.getSessionFactory().openSession();
        session.createSQLQuery("create table if not exists USER ( id int primary key auto_increment,   name varchar(200)," +
                "    lastName varchar(200),    age int)").executeUpdate();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session =  Util.getSessionFactory().openSession();
        session.createSQLQuery("drop table if exists USER").executeUpdate();
        session.close();
    }

    //@Override
    public void saveUser(String name, String lastName, byte age) {
        //public void saveUser(User user){
        User newUser = new User (name,lastName,age);
        Session session =  Util.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(newUser);
        tx1.commit();
        session.close();

    }


    public User findById(int id) {
        return (User) Util.getSessionFactory().openSession().get(User.class, id);
    }

    @Override
    public void removeUserById(long id) {
        User userForDelete = findById( (int) id);

        Session session = Util.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(userForDelete);
        tx1.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = (List<User>) Util.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session =  Util.getSessionFactory().openSession();
        session.createSQLQuery("delete from USER").executeUpdate();
        session.close();
    }
}
