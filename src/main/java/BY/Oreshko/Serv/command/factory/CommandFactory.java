package BY.Oreshko.Serv.command.factory;

import BY.Oreshko.Serv.command.*;
import BY.Oreshko.Serv.command.authorithation.LoginCommand;
import BY.Oreshko.Serv.command.authorithation.RegisterNewUserCommand;
import BY.Oreshko.Serv.command.authorithation.SignOutCommand;
import BY.Oreshko.Serv.command.grouppersons.AddNewPersonCommand;
import BY.Oreshko.Serv.command.grouppersons.WelcomeCommand;

public class CommandFactory {

    public static Command create(String command){

        command = command.toUpperCase();
        System.out.println(command);
        CommandType commandEnum = CommandType.valueOf(command);

        Command resultCommand;
        switch (commandEnum){
            case LOGIN:{
                resultCommand = new LoginCommand();
                break;
            }
            case REGISTER_NEW_USER:{
                resultCommand = new RegisterNewUserCommand();
                break;
            }
            case SIGN_OUT:{
                resultCommand = new SignOutCommand();
                break;
            }
            case ADD_NEW_PERSON:{
                resultCommand = new AddNewPersonCommand();
                break;
            }
            case LOGIN_PAGE:{
                resultCommand = new LoginPageCommand();
                break;
            }
            case WELCOME:{
                resultCommand = new WelcomeCommand();
                break;
            }
            case REGISTRATION_PAGE:{
                resultCommand = new RegistrationPageCommand();
                break;
            }
            default:{
                throw new IllegalArgumentException("Invalid command" + commandEnum);
            }
        }
        return resultCommand;
    }
}
