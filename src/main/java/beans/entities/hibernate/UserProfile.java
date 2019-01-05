package beans.entities.hibernate;

import org.hibernate.annotations.ColumnTransformer;

public class UserProfile extends Profile {
    @ColumnTransformer(read = "pgp_sum_decrypt(passport_key::bytea, 'crypt')", write = "pgp_sum_encrypt(?, 'crypt')")
    private String passportKey;
}
