package BY.Oreshko.Serv;


import BY.Oreshko.Serv.dao.UserDao;
import BY.Oreshko.Serv.util.HashPassword;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        UserDao daoUser = new UserDao();
        if (daoUser.isValidUser(name, HashPassword.getHash(password))) {
            request.getSession().setAttribute("name", name);
            request.getSession().setAttribute("password", password);

            Cookie userCookie = new Cookie(name, LocalDateTime.now().toString());
            userCookie.setMaxAge(60 * 60 * 24 * 365); //хранить куки год
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    Cookie cookie = cookies[i];
                    if (name.equals(cookie.getName())) {
                        request.setAttribute("lastdate", cookie.getValue());
                    }
                }
            }

            response.addCookie(userCookie);
            // response.sendRedirect(request.getContextPath()+"/GroupServlet"); //ПЛОХО НЕТ ПАРАМЕТРОВ
                    request
                    .getRequestDispatcher("/GroupServlet")
                    .forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Неверный логин или пароль!!");
            request.getRequestDispatcher("/views/login.jsp")
                    .forward(request, response);
        }
    }
    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        request
                .getRequestDispatcher("/views/login.jsp")
                .forward(request, response);
    }
}
