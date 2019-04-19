package BY.Oreshko.Serv.builder;

import BY.Oreshko.Serv.exception.RepositoryException;

import java.sql.ResultSet;


public interface Builder<T> {
    T build(ResultSet resultSet) throws RepositoryException;
}
