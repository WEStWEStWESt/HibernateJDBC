package dao.repositories;

import dao.entity.Users;
import dao.repositories.UserRepository;
import dao.repositories.interfaces.IUserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class UserRepositoryTest {

    private static String TEST_NAME = "test_name";
    private IUserRepository dao;

    @Before
    public void setUp() {
        dao = new UserRepository();
        dao.addUser(TEST_NAME);
    }

    @Test
    public void checkOfGettingUserByName() {
       final Users USER = dao.getUser(TEST_NAME);
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
        final Users USER = dao.getUser(TEST_NAME);
        assertNull(USER);
    }

    @After
    public void tearDown() {
        dao.removeUser(TEST_NAME);
    }
}