import java.sql.*;
import java.util.Scanner;

public class CreateDatabase extends QueriesClass{

    public CreateDatabase(Statement statement) {
        super(statement);
    }
   //        statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Jane', 65656654, 'jane@mail.com')");
//        statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Fido', 65656654, 'fido@mail.com')");
//           statement.execute("UPDATE contacts SET phone=78787 WHERE name='Joe'");
//           statement.execute("DELETE FROM contacts WHERE name='Joe'");

    @Override
    public void performAction() {
        try {
            super.getStatement().execute("CREATE TABLE IF NOT EXISTS " +
                    TABLE_FOR_PERSONS + " (" +
                    FIRST_NAME + " TEXT, " +
                    LAST_NAME + " TEXT," +
                    COMPANY + " TEXT, " +
                    INCOME + " INT, " +
                    SUBSIDIZED + " BOOL)");
            int rowsNow = CountRows();
            int number = AskForInput();
            while (rowsNow < number) {
                FillFakerData();
                rowsNow = CountRows();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }//CreateDatabase
    }
        public void FillFakerData(){
        try {
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
        }catch (SQLException e){
            e.printStackTrace();
        }
    }//FillFakerData

    public int AskForInput(){
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.println("Please enter a positive number!");
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number!");
                sc.next();
            }
            number = sc.nextInt();
        } while (number <= 0);
        System.out.println("Thank you! Got " + number);
        return number;
        }

}//Class
