package customerApp; 

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFact {

	public static final String URL = "jdbc:mysql://database-4.cgsyjtny2rf9.us-east-2.rds.amazonaws.com:3306/CustomerApp";
    public static final String USER = "admin";
    public static final String PASS = "admin123";
    
    public static Connection getConnection()
    {
      try {
          DriverManager.registerDriver(new Driver());
             return DriverManager.getConnection(URL, USER, PASS);
      } catch (SQLException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      }
    }
}
