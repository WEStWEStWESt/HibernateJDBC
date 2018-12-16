package dao.sections;

public enum  HqlQuery {

    SELECT_USER_BY_NAME("FROM Users WHERE name LIKE :name"),
    SELECT_QUESTION("FROM Questions WHERE question LIKE :question");

    private String hql;

    HqlQuery(String s) {
        hql = s;
    }

    public String getHql() {
        return hql;
    }
}
