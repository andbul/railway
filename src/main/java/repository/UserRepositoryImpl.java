package repository;

import daotest.User;
import exception.UserNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Created by andrey on 03.02.16.
 */
public class UserRepositoryImpl implements UserRepository {

    private EntityManager manager = Persistence
            .createEntityManagerFactory("RAILWAY")
            .createEntityManager();

    @Override
    public User create(){
        manager.getTransaction().begin();
        User user = new User();
        manager.persist(user);
        manager.getTransaction().commit();
        return user;
    }

    @Override
    public User read(Long id){
        return manager.find(User.class, id);
    }

    @Override
    public void update(User user){
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(Long id){
        manager.getTransaction().begin();
        User user = manager.find(User.class, id);
        manager.remove(user);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(User user){
        manager.getTransaction().begin();
        manager.remove(user);
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
