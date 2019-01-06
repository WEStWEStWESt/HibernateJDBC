package beans.entities.hibernate;

import beans.entities.hibernate.profiles.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import utils.converters.UserNameConverter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_seq")
    @SequenceGenerator(name = "gen_seq", sequenceName = "user_seq", allocationSize = 1)
    private int id;

    @Convert(converter = UserNameConverter.class)
    @Column(name = "name", nullable = false, unique = true, length = 20)
    private String name;

    @JsonIgnore
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Profile profile;

    @OneToMany(targetEntity = Link.class,
               mappedBy = "user",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<Link> links;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(int id, String name) {
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

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }

    public List<Link> getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
