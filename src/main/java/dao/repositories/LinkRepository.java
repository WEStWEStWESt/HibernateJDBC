package dao.repositories;

import beans.entities.hibernate.Answer;
import beans.entities.hibernate.Link;
import beans.entities.hibernate.Question;
import beans.entities.hibernate.User;
import dao.repositories.interfaces.ILinkRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.sections.HqlQuery;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class LinkRepository extends AbstractRepository implements ILinkRepository {

    @Override
    public List<Link> getLink(User user) {

        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        List objects =
                 session.createQuery(HqlQuery.SELECT_LINK_BY_USER.getHql())
                        .setParameter("user", user)
                        .getResultList();
        transaction.commit();
        session.close();
        return castToLinkList(objects);
    }

    @Override
    public List<Link> getLink(User user, Question question) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createSQLQuery(
                "SELECT * links " +
                   "WHERE user_id = :user_id" +
                   "AND question_id = :question_id");

        query.setParameter("user_id", user.getId());
        query.setParameter("question_id", question.getId());

        List objects = query.getResultList();

        transaction.commit();
        session.close();
        return castToLinkList(objects);
    }

    @Override
    public void addLink(Link link) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.save(link);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateLink(User user, Question question, Answer answer) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createSQLQuery(
                "UPDATE INTO links " +
                "SET answer_id = :answer_id" +
                "WHERE user_id = :user_id" +
                "AND question_id = :question_id" +
                "AND answer_id IS NULL");

        query.setParameter("answer_id", answer.getId());
        query.setParameter("user_id", user.getId());
        query.setParameter("question_id", question.getId());

        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void removeLink(Link link) {
        removeEntity(link);
    }

    private  List<Link> castToLinkList(List objects) {
        List<Link> links = new ArrayList<>();
        objects.forEach(o -> links.add((Link) o));
        return links.size() > 0 ? links : null;
    }
}
