package BY.Oreshko.Serv.dao;


import BY.Oreshko.Serv.model.Person;
import BY.Oreshko.Serv.util.ConnectorDB;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class PersonDao {
    private final static String SQL_GET_PERSONS = "select * from person";
    private final static String SQL_INSERT_PERSON = "INSERT INTO person(name1,phone,email) VALUES (? ,?, ?)";

    private static final Logger LOGGER = Logger.getLogger(PersonDao.class);

    private static Connection connection ;
    public PersonDao() {
        try {
            if (connection == null){
                connection = ConnectorDB.getConnection();
                LOGGER.info("get connection");}
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void closeConnection(){
        try {
            if (connection != null) {
                connection.close();
                LOGGER.info("close connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertPerson(Person person) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SQL_INSERT_PERSON );
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getPhone());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            LOGGER.info("New Person" + person.getName() +" inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Person> getPersons() {
        List<Person> persons = new LinkedList<Person>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_GET_PERSONS);
            Person person = null;
            while(resultSet.next()){
                person = new Person();
                person.setName(resultSet.getString("name1"));
                person.setPhone(resultSet.getString("phone"));
                person.setEmail(resultSet.getString("email"));
                persons.add(person);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }
}