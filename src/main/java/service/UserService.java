package service;

import entity.Role;
import entity.User;
import exception.DuplicateEmailException;
import exception.DuplicateException;
import exception.DuplicateLoginException;
import exception.UserNotFoundException;
import repository.UserRepository;
import repository.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by andrey on 06.02.16.
 */
public class UserService {

    private UserRepository repository = new UserRepositoryImpl();

    public List<User> getAll(){
        return repository.findAll();
    }
    public User getByLogin(String login){
        return repository.findByLogin(login);
    }
    public void update(Map<String, String> params){
        //Params reading
        String login    = params.get("login");
        String password = params.get("password");
        String email    = params.get("email");
        String name     = params.get("name");
        String surname  = params.get("surname");
        String[] rolenames;

        //Default role if null
        if(!params.containsKey("roles"))
            rolenames = new String[]{"user"};
        else
            rolenames = params.get("roles").split(" ");

        //If user is not empty add cause to error message
        User user = repository.findByLogin(login);
        if (user == null)
            throw new UserNotFoundException();

        //Success!!! Necessary fields are uniq. Trying to create new user
        user.setPassword(password);
        user.setEmail(email);
        user.setName(name);
        user.setSurname(surname);

        //Add roles for this user
        List<Role> roles = user.getRoles();
        roles.clear();

        for (String rolename : rolenames) {
            Role role = new Role();
            role.setName(rolename);
            roles.add(role);
        }
        user.setRoles(roles);

        //Try update
        try {
            repository.update(user);
        }
        catch (Exception e){
            new IllegalArgumentException("Some fields are corrupted");
        }
    }
    public void create(Map<String, String> params){
        //Params reading
        String login    = params.get("login");
        String password = params.get("password");
        String email    = params.get("email");
        String name     = params.get("name");
        String surname  = params.get("surname");
        String[] rolenames;

        //Default role if null
        if(!params.containsKey("roles"))
            rolenames = new String[]{"user"};
        else
            rolenames = params.get("roles").split(" ");

        //If user is not empty add cause to error message
        User userByLogin = repository.findByLogin(login);
        User userByEmail = repository.findByEmail(email);

        if (userByLogin != null && userByEmail != null)
            throw new DuplicateException();

        if (userByLogin != null)
            throw  new DuplicateLoginException();

        if (userByEmail != null)
            throw new DuplicateEmailException();

        //Success!!! Necessary fields are uniq. Trying to create new user
        User user = new User();

        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setName(name);
        user.setSurname(surname);

        //Add roles for this user
        ArrayList<Role> roles = new ArrayList<Role>();

        for (String rolename : rolenames) {
            Role role = new Role();
            role.setName(rolename);
            roles.add(role);
        }
        user.setRoles(roles);

        //Try create
        try {
            repository.create(user);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new IllegalArgumentException("Some fields are corrupted");
        }
    }

}
