package controller.admin;

import controller.UserController;
import entity.User;
import enums.CrudMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrey on 08.02.16.
 */
public class AdminController extends UserController {

    public void doGetCreate(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/pages/admin/create.jsp").forward(req, resp);
    }

    public void doPostCreate(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doCrudMethod(CrudMethod.CREATE, req, resp, "login", "password", "name", "surname", "email", "roles");
    }

    public void doGetUpdate(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User user = service.getByLogin(req.getParameter("login"));
        req.setAttribute("user", user);
        req.getRequestDispatcher("/pages/admin/update.jsp").forward(req, resp);
    }

    public void doPostUpdate(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doCrudMethod(CrudMethod.UPDATE, req, resp, "login", "password", "name", "surname", "email", "roles");
    }

    protected void doGetShow(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("users", service.getAll());
        req.getRequestDispatcher("/pages/admin/show.jsp").forward(req, resp);
    }

}
