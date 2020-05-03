import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrintOut extends QueriesClass{
  public PrintOut(Statement statement) {
    super(statement);
  }

    @Override
    public void performAction() throws SQLException {
        ResultSet resultSet = FetchDatabase();
        int rowNumber = 1;
        while (resultSet.next()) {
            String name = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int income = resultSet.getInt("income");
            System.out.println(rowNumber + " " + name + " " + lastName + " " + income);
            rowNumber++;
        }//while
        resultSet.close();
    }//PrintoutDatabase
}


