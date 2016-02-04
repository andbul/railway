package service;

import daotest.User;
import exception.UserNotFoundException;
import repository.UserRepository;
import repository.UserRepositoryImpl;

/**
 * Created by andrey on 04.02.16.
 */
public class LoginService {

    private UserRepository repository = new UserRepositoryImpl();

    public boolean authenticateUser(String login, String password){
        try {
            User user = repository.findByLoginAndPassword(login, password);
            return true;
        }
        catch (UserNotFoundException e)
        {
            return false;
        }
    }
}
