package dao.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_seq")
    @SequenceGenerator(name = "gen_seq", sequenceName = "user_seq", allocationSize = 1)
    private int id;

    @Column(name = "name", nullable = false, unique = true, length = 20)
    private String name;

    @OneToMany(targetEntity = Link.class,
               mappedBy = "user",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<Link> links;

    public Users() {
    }

    public Users(String name) {
        this.name = name;
    }

    public Users(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Link> getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return name;
    }
}
