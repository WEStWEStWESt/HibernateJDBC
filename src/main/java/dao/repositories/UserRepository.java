package dao.repositories;

import beans.entities.hibernate.User;
import dao.repositories.interfaces.IUserRepository;
import utils.sections.HqlQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserRepository extends AbstractRepository implements IUserRepository {

    @Override
    public User getUser(String name){
        String screen = "%";
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        User user = (User) session.createQuery(HqlQuery.SELECT_USER_BY_NAME.getHql())
                                    .setParameter("name", screen + name + screen)
                                    .uniqueResult();
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public void addUser(String name){
        if (getUser(name) == null) {
            Session session = getSession();
            Transaction transaction = session.beginTransaction();
            session.save(new User(name));
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void removeUser(String name){
        User user;
        if ((user = getUser(name)) != null){
           removeEntity(user);
        }
    }
}
