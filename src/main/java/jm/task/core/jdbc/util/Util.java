package jm.task.core.jdbc.util;

import com.mysql.cj.Session;
import org.hibernate.SessionFactory;
import jm.task.core.jdbc.model.User;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;


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

    ///пример с javarush

    private static SessionFactory sessionFactory;

    public Util() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = (SessionFactory) configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение! в getSessionFactory!!! " + e);
            }
        }
        return sessionFactory;
    }


   

//// Это с ролика индуса на ютуюе, не работает
    /*
    private String DB_DRIVER_NAME = "";
    private String DB_URL = "jdbc:mysql://localhost:3306/new_db";
    private String DB_USERNAME = "root";
    private String DB_PASSWORD = "qweQwe52";
    private String DIALECT = "org.hibernate.dialect.H2Dialect";
    private String HBM2DLL = "create";
    private String SHOW_SQL = "true";

    private static Configuration config;
    private static SessionFactory sessionFactory;
    private Session session;

    private boolean CLOSE_AFTER_TRANSACTION = false;

    public void LiveHibernateConnector() {

        config = new Configuration();

        config.setProperty("hibernate.connector.driver_class",         DB_DRIVER_NAME);
        config.setProperty("hibernate.connection.url",                 DB_URL);
        config.setProperty("hibernate.connection.username",         DB_USERNAME);
        config.setProperty("hibernate.connection.password",         DB_PASSWORD);
        config.setProperty("hibernate.dialect",                     DIALECT);
        config.setProperty("hibernate.hbm2dll.auto",                 HBM2DLL);
        config.setProperty("hibernate.show_sql",                    SHOW_SQL);
*/

////////////////Config connection pools

/*
        config.setProperty("connection.provider_class", "org.hibernate.connection.C3P0ConnectionProvider");
        config.setProperty("hibernate.c3p0.min_size", "5");
        config.setProperty("hibernate.c3p0.max_size", "20");
        config.setProperty("hibernate.c3p0.timeout", "300");
        config.setProperty("hibernate.c3p0.max_statements", "50");
        config.setProperty("hibernate.c3p0.idle_test_period", "3000");



/// Resource mapping


//        config.addAnnotatedClass(User.class);
//        config.addAnnotatedClass(User.class);
//        config.addAnnotatedClass(User.class);

        sessionFactory = (SessionFactory) config.buildSessionFactory();
    }


    public HibWrapper openSession() throws HibernateException {
        return new HibWrapper(getOrCreateSession(), CLOSE_AFTER_TRANSACTION);
    }


    public Session getOrCreateSession() throws HibernateException {
        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public void reconnect() throws HibernateException {
        this.sessionFactory = config.buildSessionFactory();
    }

*/

/*
    private static StandardServiceRegistry standServRegistry;
    private static SessionFactory sessionFactory;

    static {
        StandardServiceRegistryBuilder sSRB = new StandardServiceRegistryBuilder();
        Map<String,String> dbSetting = new HashMap<>();
        dbSetting.put(Environment.URL, "jdbc:mysql://localhost:3306/new_db?useSSL=false&serverTimezone=UTC");
        dbSetting.put(Environment.USER, "root");
        dbSetting.put(Environment.PASS, "qweQwe52");
        dbSetting.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        dbSetting.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

        sSRB.applySetting(dbSetting);

        standServRegistry = sSRB.build();

        MetadataSources sources = new MetadataSources(standServRegistry);

        Metadata metadata = sources.getMetadataBuilder().build();

        sessionFactory = (SessionFactory) metadata.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
*/


}
