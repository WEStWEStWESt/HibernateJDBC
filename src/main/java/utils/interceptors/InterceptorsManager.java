package utils.interceptors;

import beans.entities.hibernate.User;
import exceptions.EntityValidationException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;

public class InterceptorsManager extends EmptyInterceptor {

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {

        return super.onSave(entity, id, state, propertyNames, types);
    }
}
