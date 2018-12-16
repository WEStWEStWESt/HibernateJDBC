package dao.driver;

import beans.entities.hibernate.Answer;
import beans.entities.hibernate.Link;
import beans.entities.hibernate.Question;
import beans.entities.hibernate.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateFactoryManager {

    private static  HibernateFactoryManager instance;
    private SessionFactory factory;
    private static final Object EMPTY_OBJECT = new Object();

    private HibernateFactoryManager() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Question.class);
        configuration.addAnnotatedClass(Answer.class);
        configuration.addAnnotatedClass(Link.class);

        StandardServiceRegistryBuilder builder =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        factory = configuration.buildSessionFactory(builder.build());
    }

    public static HibernateFactoryManager getInstance(){
        synchronized (EMPTY_OBJECT) {
            if (instance == null) {
                instance = new HibernateFactoryManager();
            }
        }
        return instance;
    }

    public SessionFactory getFactory(){
        return factory;
    }

    /*create sequence quest_seq START 1;
  ALTER TABLE questions ALTER COLUMN id
      SET DEFAULT nextval('quest_seq');
ALTER SEQUENCE quest_seq OWNED BY questions.id;*/
}
