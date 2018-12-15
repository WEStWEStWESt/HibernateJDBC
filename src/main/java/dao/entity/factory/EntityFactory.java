package dao.entity.factory;

import dao.entity.Answers;
import dao.entity.Questions;
import dao.entity.Users;

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
