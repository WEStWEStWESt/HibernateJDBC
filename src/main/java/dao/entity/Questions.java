package dao.entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "questions")
public class Questions {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quest_seq")
    @SequenceGenerator(name = "quest_seq", sequenceName = "quest_seq", allocationSize = 1)
    private int id;

    @Column(name = "question")
    private String question;

    public Questions() {
    }

    public Questions(String question) {
        this.question = question;
    }

    public Questions(int id, String question) {
        this.id = id;
        this.question = question;
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
