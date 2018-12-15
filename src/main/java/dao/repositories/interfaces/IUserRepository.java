package dao.repositories.interfaces;

import dao.entity.Users;

public interface IUserRepository {
    Users getUser(String name);

    void addUser(String name);

    void removeUser(String name);
}
