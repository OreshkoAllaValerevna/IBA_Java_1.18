package BY.Oreshko.Serv.listObject;

import BY.Oreshko.Serv.model.Person;

import java.util.ArrayList;
import java.util.List;

public class ListService {

        private static List<Person> groupList=new ArrayList<>();
        static {
            groupList.add(new Person("Anna", "+375291111111", "nikname@ya.ru"));
            groupList.add(new Person("Alla", "+375292222222", "nikname1@ya.ru"));
            groupList.add(new Person("Olga", "+375293333333", "nikname2@ya.ru"));
        }

        static public List<Person> retrieveList(){
            return groupList;
        }

        static public void addPerson (Person person){
            groupList.add(new Person(person));
        }
}

