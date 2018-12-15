package dao.sections;

public enum  HqlQuery {

    SELECT_USER_BY_NAME("FROM Users WHERE name LIKE :name");

    private String hql;

    HqlQuery(String s) {
        hql = s;
    }

    public String getHql() {
        return hql;
    }
}
