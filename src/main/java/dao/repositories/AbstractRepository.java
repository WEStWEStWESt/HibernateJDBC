package dao.repositories;

import dao.driver.HibernateFactoryManager;
import dao.entity.Questions;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class AbstractRepository {

     Session getSession(){
        return HibernateFactoryManager.getInstance()
                .getFactory()
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
