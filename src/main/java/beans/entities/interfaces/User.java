package beans.entities.interfaces;

import beans.entities.hibernate.Link;

import java.util.List;

public interface User {
    void setId(long id);

    long getId();

    String getName();

    void setName(String name);

    List<Link> getLinks();
}
