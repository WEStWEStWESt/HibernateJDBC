package dao.repositories;

import beans.entities.hibernate.profiles.UserProfile;
import dao.repositories.interfaces.IProfileRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProfileService extends AbstractService implements IProfileRepository {

    @Override
    public UserProfile getUserProfile(UserProfile userProfile) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        userProfile = session.get(UserProfile.class, userProfile.getId());

        transaction.commit();
        session.close();
        return userProfile;
    }

    @Override
    public boolean addUserProfile(UserProfile userProfile) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        if (getUserProfile(userProfile) == null) {
            session.save(userProfile);
        }
        transaction.commit();
        session.close();
        return getUserProfile(userProfile) != null;

    }

    @Override
    public boolean delete(UserProfile userProfile) {
        if ((userProfile = getUserProfile(userProfile)) != null) {
            removeEntity(userProfile);
        }
        return getUserProfile(userProfile) == null;
    }
}
