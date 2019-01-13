package utils.interceptors.implementations.validators;

import beans.entities.hibernate.User;
import exceptions.EntityValidationException;
import utils.interceptors.interfaces.ValidationInterceptor;

public class UserValidationInterceptor implements ValidationInterceptor {
    @Override
    public void validate(Object entity) {
        System.out.println("*** The UserEntity saving ***");
        if (entity instanceof User) {
            User user = (User) entity;
            String name = user.getName();
            if (name == null || name.isEmpty()) {
                throw new EntityValidationException("*** Name field value is invalid ***");
            }
        }
    }
}
