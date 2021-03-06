package dao.repositories;

import beans.entities.hibernate.User;
import dao.repositories.interfaces.IUserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class UserRepositoryTest {

    private static String TEST_NAME = "Test_name";
    private IUserRepository dao;

    @Before
    public void setUp() {
        dao = new UserService();
        dao.addUser(TEST_NAME);
    }

    @Test
    public void checkOfGettingUserByName() {
       final User USER = dao.getUser(TEST_NAME);
       assertNotNull(USER);
    }

    @Test
    public void checkOfAddingUserByName(){
        String ACTUAL_NAME = dao.getUser(TEST_NAME).getName();
        assertThat(ACTUAL_NAME, is(equalTo(TEST_NAME)));
    }

    @Test
    public void checkOfRemovingUserByName(){
        dao.removeUser(TEST_NAME);
        final User USER = dao.getUser(TEST_NAME);
        assertNull(USER);
    }

    @After
    public void tearDown() {
        dao.removeUser(TEST_NAME);
    }
}