package BY.Oreshko.Serv.command.authorithation;

import BY.Oreshko.Serv.command.Command;
import BY.Oreshko.Serv.command.CommandResult;
import BY.Oreshko.Serv.command.session.SessionAttribute;
import BY.Oreshko.Serv.exception.IncorrectDataException;
import BY.Oreshko.Serv.exception.ServiceException;
import BY.Oreshko.Serv.util.pages.Page;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignOutCommand implements Command {
    private static final Logger LOGGER =
            Logger.getLogger(SignOutCommand.class.getName());
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, IncorrectDataException {
        HttpSession session = request.getSession();
        String username =
                (String)session.getAttribute(SessionAttribute.NAME);
        LOGGER.info("user was above: name:" + username);
        session.removeAttribute(SessionAttribute.NAME);
        return new CommandResult(Page.LOGIN_PAGE.getPage(), false);
    }
}
