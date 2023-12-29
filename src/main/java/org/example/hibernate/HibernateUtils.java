package org.example.hibernate;

import lombok.Getter;
import org.example.entities.Client;
import org.example.entities.Planet;
import org.example.postgresdb.PostgresDBInitService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Configures Hibernates as singleton
 */
public class HibernateUtils {

    private static final HibernateUtils INSTANCE = new HibernateUtils();
    private SessionFactory sessionFactory;

    private HibernateUtils() {
        //configure hibernate
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();
    }

    public static HibernateUtils getInstance(){
        return INSTANCE;
    }

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public void close(){
        sessionFactory.close();
    }
}
