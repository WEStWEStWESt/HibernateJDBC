package dao.impl.implHibernate;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class UserHibernateTableTest {

    private static final String TEST_NAME = "test";
    private UserHibernateTable dao;

    @Before
    public void setUp() throws Exception {
        dao = new UserHibernateTable();
    }

    @Test
    public void getUser() {
       final int TEST_ID = 2;
       String EXPECTED_NAME = "WESt";
       String ACTUAL_NAME = dao.getUser(TEST_ID).getName();
       assertThat(ACTUAL_NAME, is(equalTo(EXPECTED_NAME)));

    }

    @Test
    public void CheckOfAddingUser(){
        String EXPECTED_NAME = TEST_NAME;
        dao.addUser(TEST_NAME);
        String ACTUAL_NAME = dao.getUser(TEST_NAME).getName();
        assertThat(ACTUAL_NAME, is(equalTo(EXPECTED_NAME)));
        dao.removeUser(TEST_NAME);
    }
}