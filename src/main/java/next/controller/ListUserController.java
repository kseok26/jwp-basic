package next.controller;

import next.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController implements Controller {
    @Override
    public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(!UserSessionUtils.isLogined(request.getSession())) {
            return "redirect:/user/loginForm";
        }
        UserDao userDataBase = new UserDao();
        request.setAttribute("users", userDataBase.findAll());
        return "/user/list.jsp";
    }
}
