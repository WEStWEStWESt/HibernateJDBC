package dao.repositories.interfaces;

import beans.entities.hibernate.Users;

public interface IUserRepository {
    Users getUser(String name);

    void addUser(String name);

    void removeUser(String name);
}
