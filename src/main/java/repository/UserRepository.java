package repository;

import entity.User;
import exception.NotFoundException;
import exception.UserNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Created by andrey on 03.02.16.
 */
public class UserRepository implements Repository {
    private EntityManager manager = Persistence.createEntityManagerFactory("RAILWAY").createEntityManager();

    public void delete(long id){
        manager.getTransaction().begin();
        manager.remove(get(id));
        manager.getTransaction().commit();
    }

    public User get(long id){
        return manager.find(User.class, id);
    }

    public void save(User user){
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
    }

    public User findByLogin(String login) throws UserNotFoundException {
        try {
            Query query = manager
                    .createQuery("SELECT u FROM User u WHERE u.login = :login")
                    .setParameter("login", login);
            return (User) JpaHelper.getSingleResult(query);
        } catch (NotFoundException e) {
            throw new UserNotFoundException();
        }
    }
    public User findByEmail(String email) throws UserNotFoundException {
        try {
            Query query = manager
                    .createQuery("SELECT u FROM User u WHERE u.email = :email")
                    .setParameter("email", email);
            return (User) JpaHelper.getSingleResult(query);
        } catch (NotFoundException e) {
            throw new UserNotFoundException();
        }
    }
    public User findByLoginAndPassword(String login, String password) throws UserNotFoundException {
        try {
            Query query = manager
                    .createQuery("SELECT u FROM User u WHERE u.login = :login AND u.password = :password")
                    .setParameter("login", login)
                    .setParameter("password", password);
            return (User) JpaHelper.getSingleResult(query);
        } catch (NotFoundException e) {
            throw new UserNotFoundException();
        }
    }

}
