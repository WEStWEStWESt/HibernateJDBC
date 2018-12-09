package dao.impl.implHibernate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class UserHibernateTableTest {

    @Test
    public void getUser() {
       final int TEST_ID = 2;
       String EXPECTED_NAME = "WESt";
       String ACTUAL_NAME = new UserHibernateTable().getUser(TEST_ID).getName();
       assertThat(ACTUAL_NAME, is(equalTo(EXPECTED_NAME)));

    }
}