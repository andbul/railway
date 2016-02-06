package repository;

import daotest.User;

/**
 * Created by andrey on 04.02.16.
 */
public interface UserRepository extends GenericDAO<User, String> {
    User findByLogin(String login);
    User findByEmail(String email);
    User findByLoginAndPassword(String login, String password);
}
