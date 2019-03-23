package BY.Oreshko.Serv;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {

    public boolean checkLogin (String name, String passw){
        return (name.equalsIgnoreCase("admin") && passw.equalsIgnoreCase("admin"));
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String pass = request.getParameter("password");

    if (checkLogin(name, pass)){
        request.setAttribute("name", request.getParameter("name"));
        request.getRequestDispatcher("/GroupServlet").forward(request, response);
    } else {
        request.setAttribute("error", "Invalid password and/or login");
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
}}

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Init");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Destroy");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("Service");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }
}
