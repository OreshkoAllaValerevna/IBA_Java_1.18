package BY.Oreshko.Serv.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/GroupServlet", filterName="LoginRequiredFilter")
public class LoginRequiredFilter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        if (request.getSession().getAttribute("name") != null) {
            chain.doFilter(req, resp);
        } else {
            request.getRequestDispatcher("/LoginServlet").forward(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
