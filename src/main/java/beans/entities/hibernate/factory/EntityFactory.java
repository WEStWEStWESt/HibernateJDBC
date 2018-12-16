package beans.entities.hibernate.factory;

import beans.entities.hibernate.Answers;
import beans.entities.hibernate.Questions;
import beans.entities.hibernate.Users;

public class EntityFactory {

    private enum EntityType {
        USERS {
            @Override
            Object createEntity(String value) {
                return new Users(value);
            }
        },
        QUESTIONS {
            @Override
            Object createEntity(String value) {
                return new Questions(value);
            }
        },
        ANSWERS {
            @Override
            Object createEntity(String value) {
                return new Answers(value);
            }
        };

        abstract Object createEntity(String value);
    }

    public static Object getEntity(String value, String entityType) {
        return EntityType.valueOf(entityType.toUpperCase()).createEntity(value);
    }
}
