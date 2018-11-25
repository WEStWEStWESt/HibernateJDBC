package dao.sections;

public enum SqlQuery {

    INSERT_USER("INSERT INTO users (name) VALUES (?)"),
    INSERT_QUESTION("INSERT INTO questions (question) VALUES (?)"),
    SELECT_USER("SELECT * FROM users WHERE name = ?"),
    SELECT_QUESTION("SELECT * FROM questions WHERE question = ?");

    private final String sql;

    SqlQuery(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
