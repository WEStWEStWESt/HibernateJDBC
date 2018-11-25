package dao.sections;

public enum SqlQuery {

    INSERT_USER("INSERT INTO users (name) VALUES (?)"),
    INSERT_QUESTION("INSERT INTO questions (question) VALUES (?)"),
    INSERT_ANSWER("INSERT INTO answers (answer) VALUES (?)"),
    INSERT_QUESTION_LINK("INSERT INTO links (user_id, question_id) VALUES (?,?)"),
    SELECT_USER("SELECT * FROM users WHERE name = ?"),
    SELECT_QUESTION("SELECT * FROM questions WHERE question = ?"),
    SELECT_ANSWER("SELECT * FROM answers WHERE answer = ?"),
    SELECT_QUESTION_LINK("SELECT * FROM links WHERE user_id = ? AND question_id = ?");


    private final String sql;

    SqlQuery(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
