import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PopulateDatabase {
    Statement statement;
    private String result;

    public PopulateDatabase(Statement statement) {
        this.statement = statement;
    }

    public ResultSet CreateDatabase() throws SQLException {

        statement.execute("CREATE TABLE IF NOT EXISTS persons (first_name TEXT, last_name TEXT, company TEXT, income INT)");
        DataFaker data = new DataFaker();
        statement.execute("INSERT INTO persons (first_name, last_name, company, income) VALUES('" + data.GenerateName()[0] + "','" + data.GenerateName()[0] + "'," +
                " '" + data.GenerateCompany() + "','" + data.GenerateIncome() + "')");
        statement.execute("SELECT * FROM persons");
        return statement.getResultSet();
    }
    public String PrintoutDatabase(ResultSet resultSet) throws SQLException {

        return result;
    }

}
