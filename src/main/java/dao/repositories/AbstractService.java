package dao.repositories;

import dao.driver.HibernateFactoryManager;
import org.hibernate.Interceptor;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class AbstractService {

     Session getSession(){
        return HibernateFactoryManager.getInstance()
                .getFactory()
                .openSession();
    }

    Session getSessionWithInterceptor(Interceptor interceptor) {
         return HibernateFactoryManager.getInstance()
                                       .getFactory()
                                       .withOptions()
                                       .interceptor(interceptor)
                                       .openSession();
    }

    void removeEntity(Object o){
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(o);
        transaction.commit();
        session.close();
    }

}
