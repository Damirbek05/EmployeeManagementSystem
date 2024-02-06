import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DBConnection {
    static Connection con;
    public static Connection createDBConnection(){

        try{
            //load driver
            Class.forName("com.mysql.jdbc.Driver");
            //get connection
            String url = "jdbc:mysql://localhost:4444/employeeDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String username = "root";
            String password = "damirbek.04";
            con = DriverManager.getConnection(url,username,password);
        } catch(Exception ex){
            ex.printStackTrace();
        }

        return con;
    }
}
