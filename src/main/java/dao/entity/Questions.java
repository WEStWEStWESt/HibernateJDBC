package dao.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@Entity
@Table(name = "questions")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quest_seq")
    @SequenceGenerator(name = "quest_seq", sequenceName = "quest_seq", allocationSize = 1)
    private int id;

    @Column(name = "question")
    private String question;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Link> links;

    public Questions() {
    }

    public Questions(String question) {
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

    public List<Link> getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return question;
    }
}
