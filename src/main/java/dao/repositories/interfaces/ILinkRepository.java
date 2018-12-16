package dao.repositories.interfaces;

import beans.entities.hibernate.Link;

public interface ILinkRepository {
    Link getLink(String link);

    void addLink(String link);

    void removeLink(String link);
}
