package dao.repositories.interfaces;

import beans.entities.hibernate.profiles.UserProfile;

public interface IProfileRepository {
    UserProfile getUserProfileByUser(UserProfile profile);

    UserProfile getUserProfile(UserProfile profile);

    boolean addUserProfile(UserProfile profile);

    boolean delete(UserProfile userProfile);
}
