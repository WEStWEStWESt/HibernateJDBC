package beans.entities.hibernate.profiles;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;

@Entity
@DiscriminatorValue("UP")
public class UserProfile extends Profile {

    /*call the command in postgresql console: CREATE EXTENSION IF NOT EXISTS pgcrypto */
    @Column(name = "passport_key")
    @ColumnTransformer(read = "pgp_sym_decrypt(passport_key::bytea, 'crypt')", write = "pgp_sym_encrypt(?, 'crypt')")
    private String passportKey;

    public UserProfile() {
    }

    public UserProfile(int age, String passportKey) {
        setAge(age);
        setPassportKey(passportKey);
    }

    public String getPassportKey() {
        return passportKey;
    }

    public void setPassportKey(String passportKey) {
        this.passportKey = passportKey;
    }
}
