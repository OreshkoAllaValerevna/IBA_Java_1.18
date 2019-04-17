package BY.Oreshko.Serv.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;



public class ConnectorDB
{
    private static final Logger LOGGER = Logger.getLogger(ConnectorDB.class);

    public static Connection getConnection() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("db",
                Locale.getDefault());
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        String driver = resource.getString("db.driver");
        try {
            Class.forName(driver);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }



        LOGGER.info("connection establish");

        return DriverManager.getConnection(url, user, pass);
    }
}