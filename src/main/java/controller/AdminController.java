package controller;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by andrey on 06.02.16.
 */
public class AdminController extends HttpServlet{

    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> params = (Map<String, String>) req.getParameterMap();
        if (params.containsKey("users"));
        if (params.containsKey("roles"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> params = ControllerHelper
                .getNecessaryParamsMap(req,"login", "password","name","surname","email","roles");
        ControllerHelper.doPostOrPutUser(params,"update",req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> params = ControllerHelper
                .getNecessaryParamsMap(req,"login", "password","name","surname","email","roles");
        ControllerHelper.doPostOrPutUser(params,"create",req,resp);
    }
}
