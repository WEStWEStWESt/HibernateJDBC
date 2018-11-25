package dao.sections;

public enum SqlQuery {

    INSERT_USER("INSERT INTO users (name) VALUES (?)"),
    SELECT_USER("SELECT * FROM users WHERE name = ?");

    private final String sql;

    SqlQuery(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
