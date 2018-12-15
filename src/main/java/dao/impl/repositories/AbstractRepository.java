package dao.impl.repositories;

import dao.driver.HibernateFactoryManager;
import org.hibernate.Session;

public abstract class AbstractRepository {

     Session getSession(){
        return HibernateFactoryManager.getInstance()
                .getFactory()
                .openSession();
    }
}
