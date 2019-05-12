package BY.Oreshko.Serv.service;

import BY.Oreshko.Serv.exception.RepositoryException;
import BY.Oreshko.Serv.exception.ServiceException;
import BY.Oreshko.Serv.model.Person;
import BY.Oreshko.Serv.repository.PersonRepository;
import BY.Oreshko.Serv.repository.RepositoryCreator;

import java.util.List;

public class PersonService {

    public List<Person> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            PersonRepository personRepository =
                    repositoryCreator.getPersonRepository();
            return personRepository.findAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    public void save(Person person) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            PersonRepository personRepository =
                    repositoryCreator.getPersonRepository();
            personRepository.save(person);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }
}
