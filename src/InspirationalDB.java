import java.sql.*;
/**
 * This class uses derby to connect or disconnect to the Inspriational People Data Base
 * 
 * @author Tom Beck
 *
 */
public class InspirationalDB
{
	/**
	 * Establishes a directory to the database, sets up a url, username and password.
	 * If a succesfull connection is unable to be made, an error is caught
	 * @return a valid connection to the databse
	 */
    public static Connection getConnection()
    {
        Connection connection = null;
        try
        {
            // if necessary, set the home directory for Derby
            String dbDirectory = "C:/Users/MAX-Student/Desktop/Java Boot Camp/Java/InspirationalPeopleHTMLGenerator";
            System.setProperty("derby.system.home", dbDirectory);

            // set the db url, username, and password
            String url = "jdbc:derby:InspirationalPeopleDB";
            String username = "";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);
            return connection;
        }
        catch (SQLException e)
        {
            for (Throwable t : e)
                t.printStackTrace();   // for debugging
            return null;
        }
    }

    /**
     * disconnects from the database
     * @return A boolean specifying if the disconnection was successfull or not.
     */
    public static boolean disconnect()
    {
        try
        {
            // On a successful shutdown, this throws an exception
            String shutdownURL = "jdbc:derby:;shutdown=true";
            DriverManager.getConnection(shutdownURL);
        }
        catch (SQLException e)
        {
            if (e.getMessage().equals("Derby system shutdown."))
                return true;
        }
        return false;
    }
}