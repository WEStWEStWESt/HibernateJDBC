package dao.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@Entity
@Table(name = "answers")
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_seq")
    @SequenceGenerator(name = "gen_seq", sequenceName = "answer_seq", allocationSize = 1)
    private int id;

    @Column(name = "answer", unique = true, length = 50)
    private String answer;

    @OneToMany(targetEntity = Link.class,
               mappedBy = "answer",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<Link> links;

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

    public List<Link> getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return answer;
    }
}
