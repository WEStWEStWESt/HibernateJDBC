package dao.driver;

import dao.entity.Users;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateFactoryManager {

    private static  HibernateFactoryManager instance;
    private SessionFactory factory;
    private static final Object EMPTY_OBJECT = new Object();

    private HibernateFactoryManager() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Users.class);
        StandardServiceRegistryBuilder builder =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        factory = configuration.buildSessionFactory(builder.build());
    }

    public static HibernateFactoryManager getInstance(){
        synchronized (EMPTY_OBJECT) {
            if (instance == null) {
                instance = new HibernateFactoryManager();
            }
        }
        return instance;
    }


}