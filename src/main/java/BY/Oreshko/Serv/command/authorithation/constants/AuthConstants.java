package BY.Oreshko.Serv.command.authorithation.constants;

public class AuthConstants {

    //Login jsp
    public static final String LOGIN = "name";
    public static final String PASSWORD = "password";

    //ERROR MESSAGE
    public final static String ERROR_MESSAGE = "errorMessage";
    public final static String ERROR_MESSAGE_TEXT = "Неверный логин или пароль, заполните все поля";
    public final static String AUTHENTICATION_ERROR_TEXT = "Неверный логин или пароль!!";
    public final static String REGISTER_ERROR_MESSAGE_IF_EXIST ="Выберите другое имя, такой пользователь существует";
    public final static String REGISTER_ERROR ="errorRegister";
    public final static String COMMAND_WELCOME = "/controller?command=welcome";

    //REGISTER JCP
    public static final String NAME_FOR_REGISTER = "newName";
    public static final String PASSWORD_FOR_REGISTER = "newPassword";
    public final static String FULL_REGISTER = "fullRegister";
    public final static String FULL_REGISTER_TEXT = "Вы зарегистрированы";
    
}
