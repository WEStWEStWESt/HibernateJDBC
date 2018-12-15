package dao.entity;

public class Answers {

    private int id;

    private String answer;

    public Answers() {
    }

    public Answers(String answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return answer;
    }
}
