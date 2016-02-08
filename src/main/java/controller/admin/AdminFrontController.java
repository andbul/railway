package controller.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by andrey on 08.02.16.
 */

@WebServlet("/adminpanel/*")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"admin"}))
public class AdminFrontController extends HttpServlet {

    private AdminController adminController = new AdminController();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getPathInfo();

        switch (path) {
            case "/create":
                adminController.doPostCreate(req, resp);

                break;
            case "/update":
                adminController.doPostUpdate(req, resp);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        //Default forwarding to menu
        if (path.equals("/") || path == null)
            path = "/menu";

        switch (path) {
            case "/menu":
                req.getRequestDispatcher("/pages/admin/menu.jsp").forward(req, resp);
                break;
            case "/create":
                adminController.doGetCreate(req, resp);
                break;
            case "/update":
                adminController.doGetUpdate(req, resp);
                break;
            case "/show":
                adminController.doGetShow(req, resp);
                break;
        }
    }
}
