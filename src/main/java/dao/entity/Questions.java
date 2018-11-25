package dao.entity;

public class Questions {

    private int id;
    private String question;

    public Questions() {
    }

    public Questions(String question) {
        this.question = question;
    }

    public Questions(int id, String question) {
        this(question);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return question;
    }
}
