package dao.repositories;

import beans.entities.hibernate.profiles.Profile;
import beans.entities.hibernate.profiles.UserProfile;
import dao.repositories.interfaces.IProfileRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

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

    @SuppressWarnings("ALL")
    @Override
    public UserProfile getUserProfileByUser(UserProfile profile) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        List<UserProfile> profiles = session.createQuery("FROM Profile").getResultList();

        Collections.sort(profiles);
        int id = Collections.binarySearch(profiles, profile);

        transaction.commit();
        session.close();
        return id < 0 ? null : profiles.get(id);
    }

    @Override
    public boolean addUserProfile(UserProfile userProfile) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        if (getUserProfileByUser(userProfile) == null) {
            session.save(userProfile);
        }
        transaction.commit();
        session.close();
        return getUserProfile(userProfile) != null;

    }

    @Override
    public boolean delete(UserProfile userProfile) {
        if ((userProfile = getUserProfileByUser(userProfile)) != null) {
            removeEntity(userProfile);
        }
        return getUserProfile(userProfile) == null;
    }
}
