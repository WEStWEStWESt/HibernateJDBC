package dao.entity;

public class Link extends Entity {
    private int id;
    private int userId;
    private int questionId;
    private int answerId;

    public Link() {

    }

    public Link(int userId, int questionId) {
        this.userId = userId;
        this.questionId = questionId;
    }

    public Link(int userId, int questionId, int answerId) {
        this(userId, questionId);
        this.answerId = answerId;
    }

    public Link(int id, int userId, int questionId, int answerId) {
        this(userId, questionId);
        setId(id);
        this.answerId = answerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }
}
