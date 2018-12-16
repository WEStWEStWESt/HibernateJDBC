package dao.repositories;

import beans.entities.hibernate.Link;
import dao.repositories.interfaces.ILinkRepository;

public class LinkRepository extends AbstractRepository implements ILinkRepository {

    @Override
    public Link getLink(String link) {
        return null;
    }

    @Override
    public void addLink(String link) {

    }

    @Override
    public void removeLink(String link) {

    }
}
