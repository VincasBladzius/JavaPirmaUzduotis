import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueriesClass {
    public static final String TABLE_FOR_PERSONS = "persons";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String COMPANY = "company";
    public static final String INCOME = "income";
    private Statement statement;
    private ResultSet resultCount;





    public QueriesClass(Statement statement) {
        this.statement = statement;
    }//ctor

    public void CreateDatabase(int DbSize) throws SQLException {
        statement.execute("CREATE TABLE IF NOT EXISTS " +
                TABLE_FOR_PERSONS + " (" +
                FIRST_NAME + " TEXT, " +
                LAST_NAME + " TEXT," +
                COMPANY + " TEXT, " +
                INCOME + " INT)");
        int rowsNow = CountRows();
        while (rowsNow < DbSize){
                FillFakerData();
                rowsNow = CountRows();
              }
    }//CreateDatabase

    public void FillFakerData() throws SQLException {
        DataFaker data = new DataFaker();
        statement.execute("INSERT INTO " +
                TABLE_FOR_PERSONS + " (" +
                FIRST_NAME + ", " +
                LAST_NAME + ", " +
                COMPANY + ", " +
                INCOME + ") VALUES('" +
                data.GenerateName()[0] + "','" +
                data.GenerateName()[0] + "'," +
                    " '" +
                data.GenerateCompany() + "','" +
                data.GenerateIncome() + "')");
    }//FillFakerData

    public ResultSet FetchDatabase() throws SQLException {
        statement.execute("SELECT * FROM " + TABLE_FOR_PERSONS);
        return statement.getResultSet();
    }//PrintoutDatabase

    private int CountRows() throws SQLException {
        resultCount = statement.executeQuery("SELECT COUNT(*) AS rowcount FROM " + TABLE_FOR_PERSONS);
        resultCount.next();
        int count = resultCount.getInt("rowcount");
        resultCount.close();
        return count;
    }//CountRows

    public void PrintoutDataBase() throws SQLException {
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
}//class
