package config;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionManager {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static EntityManager getEntityManager() {
        return sessionFactory.createEntityManager();
    }
}
