package dao.repositories;

import beans.entities.hibernate.Answer;
import dao.repositories.interfaces.IAnswerRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.sections.HqlQuery;

public class AnswerRepository extends AbstractRepository implements IAnswerRepository {

    @Override
    public Answer getAnswer(String value) {
        String screen = "%";
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Answer answer = (Answer)
                session.createQuery(HqlQuery.SELECT_ANSWER.getHql())
                        .setParameter("answer", screen + value + screen)
                        .uniqueResult();
        transaction.commit();
        session.close();
        return answer;
    }

    @Override
    public void addAnswer(String answer) {
        if (getAnswer(answer) == null){
            Session session = getSession();
            Transaction transaction = session.beginTransaction();
            session.save(new Answer(answer));
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void removeAnswer(String value) {
        Answer answer;
        if ((answer = getAnswer(value)) != null){
            removeEntity(answer);
        }
    }
}
