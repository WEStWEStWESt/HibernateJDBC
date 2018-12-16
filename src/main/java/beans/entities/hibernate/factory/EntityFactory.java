package beans.entities.hibernate.factory;

import beans.entities.hibernate.Answer;
import beans.entities.hibernate.Question;
import beans.entities.hibernate.User;

public class EntityFactory {

    private enum EntityType {
        USERS {
            @Override
            Object createEntity(String value) {
                return new User(value);
            }
        },
        QUESTIONS {
            @Override
            Object createEntity(String value) {
                return new Question(value);
            }
        },
        ANSWERS {
            @Override
            Object createEntity(String value) {
                return new Answer(value);
            }
        };

        abstract Object createEntity(String value);
    }

    public static Object getEntity(String value, String entityType) {
        return EntityType.valueOf(entityType.toUpperCase()).createEntity(value);
    }
}
