package BY.Oreshko.Serv;

import BY.Oreshko.Serv.dao.UserDao;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    // public boolean validateUser(String user, String password) {
// return user.equalsIgnoreCase("admin") && password.equals("admin");
// }
    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        String name = request.getParameter("loginName");
        String password = request.getParameter("password");
        UserDao daoUser = new UserDao();
        if (daoUser.isValidUser(name, password)) {
            request.setAttribute("name", name);
            // response.sendRedirect(request.getContextPath()+"/GroupServlet"); //ПЛОХО НЕТ ПАРАМЕТРОВ
            request.getRequestDispatcher("/GroupServlet")
                    .forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Неверный логин или пароль!!");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                    .forward(request, response);
        }
    }
    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        request
                .getRequestDispatcher("/WEB-INF/views/login.jsp")
                .forward(request, response);
    }
}
