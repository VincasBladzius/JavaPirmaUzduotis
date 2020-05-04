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
            Subsidize subsidize = new Subsidize(statement);
            subsidize.performAction();
            printOut.performAction();
            ShowProblematic showProblematic = new ShowProblematic(statement);
            showProblematic.performAction();
            printOut.performAction();

            statement.close();
            connect.close();
        } catch (Exception e) {
            StackTraceElement[] elements = e.getStackTrace();
            System.out.println(e + " at " + elements[elements.length - 1]);
        }
    }
}
