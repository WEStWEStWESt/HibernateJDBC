package dao.impl.repositories;

import dao.driver.HibernateFactoryManager;
import dao.entity.Users;
import dao.sections.HqlQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserRepository extends AbstractRepository{

    public Users getUser(String name){
        String screen = "%";
        Session session = getSession();
        Users user = (Users) session.createQuery(HqlQuery.SELECT_USER_BY_NAME.getHql())
                                    .setParameter("name", screen + name + screen)
                                    .uniqueResult();
        session.close();
        return user;
    }

    public void addUser(String name){
        if (getUser(name) == null) {
            Session session = getSession();
            Transaction transaction = session.beginTransaction();
            session.save(new Users(name));
            transaction.commit();
            session.close();
        }
    }

    public void removeUser(String name){
        Users user;
        if ((user = getUser(name)) != null){
            Session session = getSession();
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
            session.close();
        }
    }
}
