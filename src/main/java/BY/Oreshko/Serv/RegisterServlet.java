package BY.Oreshko.Serv;


import BY.Oreshko.Serv.dao.UserDao;
import BY.Oreshko.Serv.model.User;
import BY.Oreshko.Serv.util.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/RegisterServlet",name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("newName");
        String password= request.getParameter("newPassword");
        UserDao daoUser = new UserDao();
        User user = new User(name, HashPassword.getHash(password));
        if (daoUser.insertUser(user)) {
            request.setAttribute("fullRegister", "Вы зарегистрированы");
            request.getRequestDispatcher("/views/login.jsp").forward(
                    request, response);
        }
        else{
            request.setAttribute("errorRegister", "Выберите другое имя, такой пользователь существует");
                    request.getRequestDispatcher("/views/register.jsp")
                            .forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request
                .getRequestDispatcher("/views/register.jsp")
                .forward(request, response);
    }
}


