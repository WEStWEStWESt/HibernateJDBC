package dao.repositories;

import dao.entity.Questions;
import dao.repositories.interfaces.IQuestionRepository;
import dao.sections.HqlQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class QuestionRepository extends AbstractRepository implements IQuestionRepository {

    @Override
    public Questions getQuestion(String value) {
        String screen = "%";
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Questions question = (Questions)
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
            session.save(new Questions(question));
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void removeQuestion(String value) {
        Questions question;
        if ((question = getQuestion(value)) != null){
           removeEntity(question);
        }
    }
}
