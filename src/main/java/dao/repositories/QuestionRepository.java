package dao.repositories;

import beans.entities.hibernate.Question;
import dao.repositories.interfaces.IQuestionRepository;
import utils.sections.HqlQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class QuestionRepository extends AbstractRepository implements IQuestionRepository {

    @Override
    public Question getQuestion(String value) {
        String screen = "%";
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Question question = (Question)
                             session.createQuery(HqlQuery.SELECT_QUESTION.getHql())
                            .setParameter("question", screen + value + screen)
                            .uniqueResult();
        transaction.commit();
        session.close();
        return question;
    }

    @Override
    public void addQuestion(String question) {
        if (getQuestion(question) == null){
            Session session = getSession();
            Transaction transaction = session.beginTransaction();
            session.save(new Question(question));
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void removeQuestion(String value) {
        Question question;
        if ((question = getQuestion(value)) != null){
           removeEntity(question);
        }
    }
}
