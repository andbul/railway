package repository;

import entity.User;

/**
 * Created by andrey on 04.02.16.
 */
public interface Repository {
    void save(User user);
    void delete(long id);
    User get(long id);
}
