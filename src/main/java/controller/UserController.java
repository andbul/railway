package controller;

import enums.CrudMethod;
import exception.DuplicateEmailException;
import exception.DuplicateException;
import exception.DuplicateLoginException;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrey on 07.02.16.
 */
public abstract class UserController extends HttpServlet{

    protected UserService service = new UserService();

    public void doCrudMethod(CrudMethod type, HttpServletRequest req,
                             HttpServletResponse resp, String...userFields) throws ServletException, IOException {

        Map<String, String> params = getNecessaryParamsMap(req,userFields);

        try {
            switch (type){
                case UPDATE:
                    service.update(params);
                    break;
                case CREATE:
                    service.create(params);
                    break;
            }

            req.getRequestDispatcher("/WEB-INF/success/success.jsp").forward(req, resp);
        }
        catch (DuplicateLoginException e){
            req.setAttribute("err", "Login not unique");
            req.getRequestDispatcher("/WEB-INF/errors/error.jsp").forward(req, resp);
        }
        catch (DuplicateEmailException e){
            req.setAttribute("err", "Email not unique");
            req.getRequestDispatcher("/WEB-INF/errors/error.jsp").forward(req, resp);
        }
        catch (DuplicateException e){
            req.setAttribute("err", "Login and Email are not unique");
            req.getRequestDispatcher("/WEB-INF/errors/error.jsp").forward(req, resp);
        }
        catch (IllegalArgumentException e){
            req.setAttribute("err", "Some fields are incorrect");
            req.getRequestDispatcher("/WEB-INF/errors/error.jsp").forward(req, resp);
        }
        catch (Exception e){
            req.setAttribute("err", "Unexpected exception");
            req.getRequestDispatcher("/WEB-INF/errors/error.jsp").forward(req, resp);
        }
    }

    private Map<String,String> getNecessaryParamsMap(HttpServletRequest req, String...params){
        Map<String,String> paramMap = new HashMap<>();

        for (String param : params) {
            paramMap.put(param, req.getParameter(param));
        }

        return paramMap;
    }
}
