package dao.repositories.interfaces;

import dao.entity.Link;

public interface ILinkRepository {
    Link getLink(String link);

    void addLink(String link);

    void removeLink(String link);
}
