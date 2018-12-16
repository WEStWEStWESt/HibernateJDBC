package beans.entities.jdbc;

import beans.entities.AbstractEntity;
import beans.entities.hibernate.Link;

import java.util.List;

public class JdbcUser extends AbstractEntity {
    private String name;

    public JdbcUser() {
    }

    public JdbcUser(String name) {
        this.name = name;
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Link> getLinks() {
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
