package repository;

import entity.User;

import java.util.List;

/**
 * Interface used to manage user entities<p>
 * Contains extra methods to find users<p>
 */
public interface UserRepository extends GenericDAO<User, String> {
    /**
     * Find user by login
     * @param login user login
     * @return the found user instance or null if the entity does
     *         not exist
     */
    User findByLogin(String login);

    /**
     * Find user by email
     * @param email user email
     * @return the found user instance or null if the entity does
     *         not exist
     */
    User findByEmail(String email);

    /**
     * Find user by login and password
     * @param login
     * @param password
     * @return the found user instance or null if the entity does
     *         not exist
     */
    User findByLoginAndPassword(String login, String password);

    /**
     * Get all user entities<p>
     * SELECT * FROM user <p>
     * @return  all users in table
     */
    List<User> findAll();
}
