package utils.interceptors.implementations.validators;

import beans.entities.hibernate.Question;
import exceptions.EntityValidationException;
import utils.annotations.Interceptor;
import utils.interceptors.interfaces.ValidationInterceptor;

@Interceptor(targetEntity = Question.class)
public class QuestionValidationInterceptor implements ValidationInterceptor {
    @Override
    public void validate(Object entity) {
        System.out.println("*** The QuestionEntity saving ***");
        if (entity instanceof Question) {
            Question question = (Question) entity;
            String value = question.getQuestion();
            if (value == null || value.isEmpty()) {
                throw new EntityValidationException("*** Question field value is invalid ***");
            }
        }
    }
}
