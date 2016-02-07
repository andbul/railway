package controller.admin;

import controller.UserController;
import enums.CrudMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrey on 07.02.16.
 */
public class AdminCreateUserController extends UserController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doCrudMethod(CrudMethod.CREATE, req, resp, "login", "password","name","surname","email","roles");
    }
}
