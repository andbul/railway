package repository;

import entity.User;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by andrey on 03.02.16.
 */
public class UserRepositoryImpl extends GenericDAOImpl<User,String> implements UserRepository {

    private static final Logger LOGGER = Logger.getLogger(UserRepository.class);

    @Override
    public User findByLogin(String login) {
        try {
            EntityManager manager = emf.createEntityManager();
            Query query = manager
                    .createQuery("SELECT u FROM User u WHERE u.login = :login")
                    .setParameter("login", login);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public User findByEmail(String email) {
        try {
            EntityManager manager = emf.createEntityManager();
            Query query = manager
                    .createQuery("SELECT u FROM User u WHERE u.email = :email")
                    .setParameter("email", email);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public User findByLoginAndPassword(String login, String password) {
        try {
            EntityManager manager = emf.createEntityManager();
            Query query = manager
                    .createQuery("SELECT u FROM User u WHERE u.login = :login AND u.password = :password")
                    .setParameter("login", login)
                    .setParameter("password", password);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;

        }
    }

    @Override
    public List<User> findAll() {
        EntityManager manager = emf.createEntityManager();
        Query query = manager
                .createQuery("SELECT u FROM User u");
        return (List<User>) query.getResultList();
    }
}
