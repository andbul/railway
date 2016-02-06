package controller;

import daotest.User;
import exception.UserNotFoundException;
import repository.UserRepository;
import repository.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrey on 04.02.16.
 */
public class RegisterController extends HttpServlet {

    UserRepository repository = new UserRepositoryImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login    = req.getParameter("login");
        String password = req.getParameter("password");
        String email    = req.getParameter("email");
        String name     = req.getParameter("name");
        String surname  = req.getParameter("surname");

        String errmessage = "";

        //If user is not empty add cause to error message
        try {
            User user = repository.findByLogin(login);
            errmessage += "Login already exists \n";
        }
        catch (UserNotFoundException ignored){}
        try {
            User user1 = repository.findByEmail(email);
            errmessage += "Email already exists \n";

        }catch (UserNotFoundException ignored){}

        //Error page or success
        if (errmessage.isEmpty() && !password.isEmpty() && !login.isEmpty() && !email.isEmpty()) {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            user.setName(name);
            user.setSurname(surname);
            repository.create(user);;
        }
        else{
            req.setAttribute("errmessage", errmessage);
            req.getRequestDispatcher("/pages/erroregistration.jsp").forward(req,resp);
        }
    }
}
