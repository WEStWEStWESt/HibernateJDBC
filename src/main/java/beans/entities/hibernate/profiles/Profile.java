package beans.entities.hibernate.profiles;

import beans.entities.hibernate.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "profiles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator")
public class Profile implements Comparable<Profile> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_gen_seq")
    @SequenceGenerator(name = "profile_gen_seq", sequenceName = "profile_sequence", allocationSize = 1)
    private int id;

    @JsonIgnore
    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Profile() {
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

    @Override
    public int compareTo(Profile o) {
        return Integer.compare(this.user.getId(), o.user.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return id == profile.id &&
                Objects.equals(user, profile.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user);
    }
}
