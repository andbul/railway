package controller;

import exception.DuplicateEmailException;
import exception.DuplicateException;
import exception.DuplicateLoginException;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrey on 07.02.16.
 */
public abstract class ControllerHelper {
    private final static UserService service = new UserService();

    public static void doPostOrPutUser(Map<String,String> params, String type,
                                       HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            switch (type){
                case "update":
                    service.update(params);
                    break;
                case "create":
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
            e.printStackTrace();
            req.setAttribute("err", "Unexpected exception");
            req.getRequestDispatcher("/WEB-INF/errors/error.jsp").forward(req, resp);
        }
    }

    public static Map<String,String> getNecessaryParamsMap(HttpServletRequest req, String...params){
        Map<String,String> paramMap = new HashMap<>();

        for (String param : params) {
            paramMap.put(param, req.getParameter(param));
        }

        return paramMap;
    }

}
