import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueriesClass {
    private Statement statement;
    private ResultSet resultCount;
    private int rows;


    public QueriesClass(Statement statement) {
        this.statement = statement;
    }//ctor

    public void CreateDatabase() throws SQLException {
        statement.execute("CREATE TABLE IF NOT EXISTS persons (first_name TEXT, last_name TEXT, company TEXT, income INT)");
        rows = CountRows();
    }//CreateDatabase

    public int FillFakerData() throws SQLException {
        DataFaker data = new DataFaker();
        statement.execute("INSERT INTO persons (first_name, last_name, company, income) VALUES('" + data.GenerateName()[0] + "','" + data.GenerateName()[0] + "'," +
                    " '" + data.GenerateCompany() + "','" + data.GenerateIncome() + "')");
        rows = CountRows();
        System.out.println(rows + "!");
        return rows;
    }//FillFakerData

    public ResultSet PrintoutDatabase() throws SQLException {
        statement.execute("SELECT * FROM persons");
        return statement.getResultSet();
    }//PrintoutDatabase

    private int CountRows() throws SQLException {
        resultCount = statement.executeQuery("SELECT COUNT(*) AS rowcount FROM persons");
        resultCount.next();
        int count = resultCount.getInt("rowcount");
        resultCount.close();
        return count;
    }//CountRows

    public int getRows() throws SQLException {
        return rows;
    }
}//class
