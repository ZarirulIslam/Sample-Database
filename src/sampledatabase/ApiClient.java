package sampledatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public abstract class ApiClient {
    private static Connection connector;
    
    static Connection getInstance() throws SQLException, ClassNotFoundException
    {
        if(connector==null)
        {
            Class.forName("com.mysql.jdbc.Driver");
            connector = DriverManager.getConnection("jdbc:mysql://localhost/blood_donation?"+"user=root");
        }
       return connector;
    }

}
