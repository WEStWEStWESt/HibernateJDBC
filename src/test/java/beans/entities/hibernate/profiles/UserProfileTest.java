package beans.entities.hibernate.profiles;

import dao.repositories.ProfileService;
import dao.repositories.UserService;
import dao.repositories.interfaces.IProfileRepository;
import dao.repositories.interfaces.IUserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserProfileTest{

    private static String TEST_NAME = "Test_name";
    private IUserRepository userRepository;
    private UserProfile userProfile;
    private IProfileRepository profileRepository;

    @Before
    public void setUp() throws Exception {
        userRepository = new UserService();
        userRepository.addUser(TEST_NAME);

        profileRepository = new ProfileService();
        userProfile = new UserProfile();
        userProfile.setUser(userRepository.getUser(TEST_NAME));
        userProfile.setPassportKey("123");

        profileRepository.addUserProfile(userProfile);
    }

    @After
    public void tearDown() throws Exception {
        profileRepository.delete(userProfile);
    }

    @Test
    public void checkOfCreatingUserProfile() {
        assertNotNull(profileRepository.getUserProfileByUser(userProfile));
    }
}