package utils.sections;

public enum SqlQuery {

    INSERT_USER("INSERT INTO users (name) VALUES (?)"),
    INSERT_QUESTION("INSERT INTO questions (question) VALUES (?)"),
    INSERT_ANSWER("INSERT INTO answers (answer) VALUES (?)"),
    INSERT_QUESTION_LINK("INSERT INTO links (user_id, question_id) VALUES (?,?)"),

    SELECT_USER("SELECT * FROM users WHERE name = ?"),
    SELECT_QUESTION("SELECT * FROM questions WHERE question = ?"),
    SELECT_ANSWER("SELECT * FROM answers WHERE answer = ?"),
    SELECT_BOUNDED_LINK("SELECT * FROM links WHERE user_id = ? AND question_id = ?"),
    SELECT_QUESTION_LINK("SELECT * FROM links WHERE question_id = ?"),
    SELECT_USER_LINK("SELECT * FROM links WHERE user_id = ?"),
    SELECT_ANSWER_LINK("SELECT * FROM links " +
                       "WHERE user_id = ? " +
                       "AND question_id = ? " +
                       "AND answer_id IS NULL"),
    UPDATE_LINK("UPDATE links SET answer_id = ? WHERE id = ?"),
    DELETE_USER("DELETE FROM users WHERE id = ?"),
    DELETE_QUESTION("DELETE FROM questions WHERE id = ?"),
    DELETE_ANSWER("DELETE FROM answers WHERE id = ?"),
    DELETE_LINK("DELETE FROM links WHERE id = ?"),
    VIEW_STATISTICS("SELECT users.name, questions.question, answers.answer\n" +
            "FROM users JOIN links ON users.id = links.user_id\n" +
            "           JOIN questions ON links.question_id = questions.id\n" +
            "           JOIN answers ON links.answer_id = answers.id");

    private final String sql;

    SqlQuery(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
