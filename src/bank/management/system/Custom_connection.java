package bank.management.system;
import java.sql.*;
public class Custom_connection
{
    java.sql.Connection j_connection;
    java.sql.Statement j_statement;

    public Custom_connection() {
        try
        {
            j_connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FortressFin", "root", "Dat.200320030406");
            j_statement = j_connection.createStatement();
        }
        catch (Exception e)
        {  //catch any error
            e.printStackTrace();
        }
    }
}
