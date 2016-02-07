package controller.admin;

import controller.UserController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by andrey on 06.02.16.
 */
public class AdminShowUsersController extends UserController{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> params = (Map<String, String>) req.getParameterMap();
        req.setAttribute("users", service.getAll());
        req.getRequestDispatcher("/admin/showusers.jsp").forward(req,resp);
    }



}
