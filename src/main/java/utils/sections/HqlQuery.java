package utils.sections;

public enum  HqlQuery {

    SELECT_USER_BY_NAME("FROM User WHERE name LIKE :name"),
    SELECT_QUESTION("FROM Question WHERE question LIKE :question"),
    SELECT_ANSWER("FROM Answer WHERE answer LIKE :answer"),
    SELECT_LINK_BY_USER("FROM Link WHERE user = :user");

    private String hql;

    HqlQuery(String s) {
        hql = s;
    }

    public String getHql() {
        return hql;
    }
}
