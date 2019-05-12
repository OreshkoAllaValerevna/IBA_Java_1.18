package BY.Oreshko.Serv.command.grouppersons;

import BY.Oreshko.Serv.command.Command;
import BY.Oreshko.Serv.command.CommandResult;
import BY.Oreshko.Serv.exception.IncorrectDataException;
import BY.Oreshko.Serv.exception.ServiceException;
import BY.Oreshko.Serv.model.Person;
import BY.Oreshko.Serv.service.PersonService;
import BY.Oreshko.Serv.util.pages.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static BY.Oreshko.Serv.command.grouppersons.constant.GroupConstant.*;

public class WelcomeCommand implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response)
            throws ServiceException, IncorrectDataException {
        PersonService personService = new PersonService();
        List<Person> clients = personService.findAll();
        if (!clients.isEmpty()) {
            request.setAttribute(LISTGROUP, clients);
        }
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }

}
