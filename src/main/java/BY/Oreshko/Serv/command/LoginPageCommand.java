package BY.Oreshko.Serv.command;

import BY.Oreshko.Serv.exception.IncorrectDataException;
import BY.Oreshko.Serv.exception.ServiceException;
import BY.Oreshko.Serv.util.pages.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, IncorrectDataException {
        System.out.println("LOGIN PAGE");
        return new CommandResult(Page.LOGIN_PAGE.getPage(),false);
    }
}
