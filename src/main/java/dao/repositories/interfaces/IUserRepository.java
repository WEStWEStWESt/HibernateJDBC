package dao.repositories.interfaces;

import beans.entities.hibernate.User;

public interface IUserRepository {
    User getUser(String name);

    void addUser(String name);

    void removeUser(String name);
}
