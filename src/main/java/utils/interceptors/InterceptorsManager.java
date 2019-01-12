package utils.interceptors;

import beans.entities.hibernate.User;
import exceptions.EntityValidationException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;

public class InterceptorsManager extends EmptyInterceptor {

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("*** The entity saving ***");
        if (entity instanceof User) {
            User user = (User) entity;
            String name = user.getName();
            if (name == null || name.isEmpty()) {
                throw new EntityValidationException("*** Name field value is invalid ***");
            }
        }
        return super.onSave(entity, id, state, propertyNames, types);
    }
}
