package beans.entities.hibernate;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_seq")
    @SequenceGenerator(name = "gen_seq", sequenceName = "links_seq", allocationSize = 1)
    private int id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(targetEntity = Question.class)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne(targetEntity = Answer.class)
    @JoinColumn(name = "answer_id")
    private Answer answer;

    public Link() {
    }

    public Link(User user, Question question) {
        this.user = user;
        this.question = question;
    }

    public Link(User user, Question question, Answer answer) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
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
