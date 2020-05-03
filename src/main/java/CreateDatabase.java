import java.sql.*;

public class CreateDatabase extends QueriesClass{

    public CreateDatabase(Statement statement) {
        super(statement);
    }
   //        statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Jane', 65656654, 'jane@mail.com')");
//        statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Fido', 65656654, 'fido@mail.com')");
//           statement.execute("UPDATE contacts SET phone=78787 WHERE name='Joe'");
//           statement.execute("DELETE FROM contacts WHERE name='Joe'");

    @Override
    public void performAction() throws SQLException {
        super.getStatement().execute("CREATE TABLE IF NOT EXISTS " +
                TABLE_FOR_PERSONS + " (" +
                FIRST_NAME + " TEXT, " +
                LAST_NAME + " TEXT," +
                COMPANY + " TEXT, " +
                INCOME + " INT, " +
                SUBSIDIZED + " BOOL)");
        int rowsNow = CountRows();
        while (rowsNow < 25){
            FillFakerData();
            rowsNow = CountRows();
        }
    }//CreateDatabase

    public void FillFakerData() throws SQLException {
        DataFaker data = new DataFaker();
        super.getStatement().execute("INSERT INTO " +
                TABLE_FOR_PERSONS + " (" +
                FIRST_NAME + ", " +
                LAST_NAME + ", " +
                COMPANY + ", " +
                INCOME + ", " +
                SUBSIDIZED + ") VALUES('" +
                data.GenerateName()[0] + "','" +
                data.GenerateName()[0] + "'," +
                " '" +
                data.GenerateCompany() + "','" +
                data.GenerateIncome() + "',"  + false + ")");
    }//FillFakerData
}
