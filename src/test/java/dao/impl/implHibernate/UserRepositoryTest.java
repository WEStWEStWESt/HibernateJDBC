package dao.impl.implHibernate;

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

    private static final String TEST_NAME = "test";
    private IUserRepository dao;

    @Before
    public void setUp() {
        dao = new UserRepository();
        dao.addUser(TEST_NAME);
    }

    @Test
    public void checkOfGettingUserByName() {
       String ACTUAL_NAME = dao.getUser(TEST_NAME).getName();
       assertThat(ACTUAL_NAME, is(equalTo(TEST_NAME)));
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
        assertThat(USER, is(nullValue(Users.class)));
    }

    @After
    public void tearDown() {
        dao.removeUser(TEST_NAME);
    }
}