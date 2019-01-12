package utils.interceptors.implementations.validators;

import beans.entities.hibernate.Question;
import exceptions.EntityValidationException;
import utils.interceptors.interfaces.ValidationInterceptor;

public class QuestionValidationInterceptor implements ValidationInterceptor {
    @Override
    public void validate(Object entity) {
        System.out.println("*** The entity saving ***");
        if (entity instanceof Question) {
            Question question = (Question) entity;
            String value = question.getQuestion();
            if (value == null || value.isEmpty()) {
                throw new EntityValidationException("*** Name field value is invalid ***");
            }
        }
    }
}
