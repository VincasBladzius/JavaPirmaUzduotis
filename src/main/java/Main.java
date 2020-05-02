import java.sql.*;

public class Main {
    private static Connection connect = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static String url = "jdbc:mysql://localhost:3306/pandemic";
    private static String user = "root", pass = "";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(url, user, pass);
            statement = connect.createStatement();
            PopulateDatabase populate = new PopulateDatabase(statement);
                resultSet = populate.CreateDatabase();


//        statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Jane', 65656654, 'jane@mail.com')");
//        statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Fido', 65656654, 'fido@mail.com')");
//           statement.execute("UPDATE contacts SET phone=78787 WHERE name='Joe'");
//           statement.execute("DELETE FROM contacts WHERE name='Joe'");

            int rowNumber = 1;
            while (resultSet.next()) {
                String name = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int income = resultSet.getInt("income");
                String result = rowNumber + " " + name + " " + lastName + " " + income;
                rowNumber++;
                System.out.println(result);
            }


            resultSet.close();
            statement.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
