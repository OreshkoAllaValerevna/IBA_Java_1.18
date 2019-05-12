package BY.Oreshko.Serv.command;

import BY.Oreshko.Serv.exception.IncorrectDataException;
import BY.Oreshko.Serv.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    CommandResult execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, IncorrectDataException, ServiceException, IncorrectDataException, ServletException, IOException;
}
