package dao.impl.implHibernate;

import dao.driver.HibernateFactoryManager;
import dao.entity.Users;

public class UserHibernateTable {

    public Users getUser(int id){
        return HibernateFactoryManager.getInstance()
                                      .getFactory()
                                      .openSession()
                                      .get(Users.class,id);
    }

}
