package dao.entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_seq")
    @SequenceGenerator(name = "gen_seq", sequenceName = "links_seq", allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Questions question;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answers answer;

    public Link() {
    }

    public Link(Users user, Questions question) {
        this.user = user;
        this.question = question;
    }

    public Link(Users user, Questions question, Answers answer) {
        this.user = user;
        this.question = question;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
    }

    public Answers getAnswer() {
        return answer;
    }

    public void setAnswer(Answers answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return    user.getName() + " | "
                + question.getQuestion() + " | "
                + (answer != null ? answer.getAnswer()
                                  : "has no answer yet.");
    }
}
