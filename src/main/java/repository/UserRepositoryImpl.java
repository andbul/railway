package repository;

import daotest.User;
import exception.UserNotFoundException;
import util.JpaHelper;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Created by andrey on 03.02.16.
 */
public class UserRepositoryImpl implements UserRepository {

    private EntityManager manager = JpaHelper.getManager();

    @Override
    public void create(User entity) {
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
    }

    @Override
    public User read(String id){
        return manager.find(User.class, id);
    }

    @Override
    public void update(User entity){
        manager.getTransaction().begin();
        manager.merge(entity);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(String id){
        manager.getTransaction().begin();
        User user = manager.find(User.class, id);
        manager.remove(user);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(User entity){
        manager.getTransaction().begin();
        manager.remove(entity);
        manager.getTransaction().commit();
    }

    @Override
    public User findByLogin(String login) throws UserNotFoundException {
        try {
            Query query = manager
                    .createQuery("SELECT u FROM User u WHERE u.login = :login")
                    .setParameter("login", login);
            return (User) query.getSingleResult();
        }
        catch (NoResultException e) {
            throw new UserNotFoundException();
        }
    }

    @Override
    public User findByEmail(String email) throws UserNotFoundException {
        try {
            Query query = manager
                    .createQuery("SELECT u FROM User u WHERE u.email = :email")
                    .setParameter("email", email);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            throw new UserNotFoundException();
        }
    }

    @Override
    public User findByLoginAndPassword(String login, String password) throws UserNotFoundException {
        try {
            Query query = manager
                    .createQuery("SELECT u FROM User u WHERE u.login = :login AND u.password = :password")
                    .setParameter("login", login)
                    .setParameter("password", password);
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            throw new UserNotFoundException();
        }
    }

}
