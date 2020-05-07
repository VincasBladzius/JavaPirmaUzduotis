package piRmaUzduotis;

import java.sql.ResultSet;
import java.sql.Statement;

public class PrintOut extends QueriesClass {
  public PrintOut(Statement statement) {
    super(statement);
  }

    @Override
    public void performAction(){
        try {
            ResultSet resultSet = FetchDatabase();
            int rowNumber = 1;
            while (resultSet.next()) {
                String name = resultSet.getString(FIRST_NAME);
                String lastName = resultSet.getString(LAST_NAME);
                int income = resultSet.getInt(INCOME);
                String subs = resultSet.getString(SUBSIDIZED);
                System.out.println(rowNumber + " " + name + " " + lastName + " " + income + " " + subs);
                rowNumber++;
            }//while
            resultSet.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("END OF LIST!!! \n\n");
    }//PrintoutDatabase
}


