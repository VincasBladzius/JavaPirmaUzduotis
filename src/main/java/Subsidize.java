import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Subsidize extends QueriesClass {

    public Subsidize(Statement statement) {
        super(statement);
    }

    @Override
    public void performAction() throws SQLException {
        super.getStatement().execute("UPDATE "
                + TABLE_FOR_PERSONS
                + " SET " + INCOME
                + " = " + INCOME + " + 200 , "
                + SUBSIDIZED + " = true WHERE "
                + INCOME + " < 401 ");
    }
}
