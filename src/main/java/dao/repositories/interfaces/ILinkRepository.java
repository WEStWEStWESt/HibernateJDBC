package dao.repositories.interfaces;

import beans.entities.hibernate.Answer;
import beans.entities.hibernate.Link;
import beans.entities.hibernate.Question;
import beans.entities.hibernate.User;

import java.util.List;

public interface ILinkRepository {
    
    List<Link> getLink(User user);
    List<Link> getLink(User user, Question question);
    List<Link> getLink(User user, Question question, Answer answer);

    void addLink(Link link);
    void updateLink(User user, Question question, Answer answer);

    void removeLink(Link link);

    void askQuestion(User user, Question question);

    void answerQuestion(User user, Question question, Answer answer);
}
