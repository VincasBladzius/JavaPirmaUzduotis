import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class QueriesClass {

    public static final String TABLE_FOR_PERSONS = "persons";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String COMPANY = "company";
    public static final String INCOME = "income";
    public static final String SUBSIDIZED = "subsidized";
    private Statement statement;
    private ResultSet resultCount;


    public QueriesClass(Statement statement) {
        this.statement = statement;
    }//ctor

    public abstract void performAction();

    public ResultSet FetchDatabase() throws SQLException {
        statement.execute("SELECT * FROM " + TABLE_FOR_PERSONS);
        return statement.getResultSet();
    }//PrintoutDatabase

    public int CountRows() throws SQLException {
        resultCount = statement.executeQuery("SELECT COUNT(*) AS rowcount FROM " + TABLE_FOR_PERSONS);
        resultCount.next();
        int count = resultCount.getInt("rowcount");
        resultCount.close();
        return count;
    }//CountRows

    public Statement getStatement() {
        return statement;
    }
}//class
