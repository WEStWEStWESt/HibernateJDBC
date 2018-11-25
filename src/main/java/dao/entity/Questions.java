package dao.entity;

public class Questions extends Entity{

    public Questions() {
    }

    public Questions(String question) {
        super(question);
    }

    public Questions(int id, String question) {
        super(id, question);
    }

    public String getQuestion() {
        return getContent();
    }

    public void setQuestion(String question) {
        setContent(question);
    }

    @Override
    public String toString() {
        return getContent();
    }
}
