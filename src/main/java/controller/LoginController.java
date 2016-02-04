package controller;

import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrey on 04.02.16.
 */
public class LoginController extends HttpServlet {

    LoginService loginService = new LoginService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login    = req.getParameter("login");
        String password = req.getParameter("password");

        if(loginService.authenticateUser(login, password)){
            req.getSession().setAttribute("user", login);
            resp.sendRedirect("/pages/home.jsp");
        }
        else {
            resp.sendRedirect("/pages/error.jsp");
        }

    }
}
