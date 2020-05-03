import java.sql.*;

public class Main {
    private static int DbSize = 25;
    private static Connection connect = null;
    private static Statement statement = null;
    public static final String DB_NAME = "pandemic";
    public static final String url = "jdbc:mysql://localhost:3306/" + DB_NAME;
    public static final String user = "root", pass = "";
    public static final String driver = "com.mysql.cj.jdbc.Driver";

    public static void main(String[] args) {
        try {
            Class.forName(driver);
            connect = DriverManager.getConnection(url, user, pass);
            statement = connect.createStatement();

            CreateDatabase createDatabase = new CreateDatabase(statement);
            createDatabase.performAction();
            PrintOut printOut = new PrintOut(statement);
            printOut.performAction();

            statement.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
