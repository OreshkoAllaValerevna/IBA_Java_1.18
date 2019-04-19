package BY.Oreshko.Serv;


import BY.Oreshko.Serv.dao.UserDao;
import BY.Oreshko.Serv.util.HashPassword;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

import static java.util.Optional.of;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        /*Optional<String> name = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter("name"));
        Optional<String> password = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter("password"));
        if (!name.isPresent() || !password.isPresent()){
            request.setAttribute("errorMessage", "Неверный логин или пароль, заполните все поля");
                    request.getRequestDispatcher("/views/login.jsp")
                            .forward(request, response);
        }*/

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        UserDao daoUser = new UserDao();
        if (daoUser.isValidUser(name, HashPassword.getHash(password))) {
            request.getSession().setAttribute("name", name);
            request.getSession().setAttribute("password", password);

            request
                    .getRequestDispatcher("/GroupServlet")
                    .forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Неверный логин или пароль!!");
            request.getRequestDispatcher("/views/login.jsp")
                    .forward(request, response);
        }

        Cookie userCookie = new Cookie(name, LocalDateTime.now().toString());
        userCookie.setMaxAge(60 * 60 * 24 * 365); //хранить куки год
        response.addCookie(userCookie);
        // response.sendRedirect(request.getContextPath()+"/GroupServlet"); //ПЛОХО НЕТ ПАРАМЕТРОВ

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (name.equals(cookie.getName())) {
                    request.setAttribute("lastdate", cookie.getValue());
                }
            }
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
