package controller.admin;

import controller.UserController;
import entity.User;
import enums.CrudMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrey on 07.02.16.
 */
public class AdminUpdateUsersController extends UserController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = service.getByLogin(req.getParameter("login"));
        req.setAttribute("user", user);
        req.getRequestDispatcher("/admin/updateuser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doCrudMethod(CrudMethod.UPDATE, req, resp, "login", "password","name","surname","email","roles");
    }
}
