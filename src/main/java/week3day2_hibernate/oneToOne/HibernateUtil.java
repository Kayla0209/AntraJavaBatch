package week3day2_hibernate.oneToOne;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // create the SessionFactory from hibernate.cfg.xml
            Configuration config = new Configuration().configure(
                    new File(HibernateUtil.class
                            .getClassLoader()
                            .getResource("hibernate.cfg-one-to-one.xml")
                            .getFile()));
            return config.buildSessionFactory();
        } catch (Throwable ex) {
            // make sure you log the exception, as it might be swallowed
            System.out.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // close caches and connection pools
        getSessionFactory().close();
    }
}
