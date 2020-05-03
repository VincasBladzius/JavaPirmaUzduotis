import java.sql.*;

public class populateDatabase {
    private static int DbSize = 25;
    private static Connection connect = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    public static final String DB_NAME = "pandemic";
    public static final String url = "jdbc:mysql://localhost:3306/" + DB_NAME;
    public static final String user = "root", pass = "";
    public static final String driver = "com.mysql.cj.jdbc.Driver";

     public void populate(){
         try {
             Class.forName(driver);
             connect = DriverManager.getConnection(url, user, pass);
             statement = connect.createStatement();

             QueriesClass queriesClass = new QueriesClass(statement);
             queriesClass.CreateDatabase(DbSize);

//        statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Jane', 65656654, 'jane@mail.com')");
//        statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Fido', 65656654, 'fido@mail.com')");
//           statement.execute("UPDATE contacts SET phone=78787 WHERE name='Joe'");
//           statement.execute("DELETE FROM contacts WHERE name='Joe'");

             queriesClass.PrintoutDataBase();
             statement.close();
             connect.close();
         } catch (
                 SQLException e) {
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
     }
}
