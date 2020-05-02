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
        statement.execute("CREATE TABLE IF NOT EXISTS persons (ID INT PRIMARY KEY AUTO_INCREMENT, " +
                "first_name TEXT, last_name TEXT, company TEXT, income INT)");
            DataFaker data = new DataFaker();
            statement.execute("INSERT INTO persons (first_name, last_name, company, income) VALUES('" + data.GenerateName()[0] + "','" + data.GenerateName()[0] + "'," +
                    " '" + data.GenerateCompany() + "','" + data.GenerateIncome() + "')");

            statement.execute("SELECT * FROM persons");
        resultSet = statement.getResultSet();

//        statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Jane', 65656654, 'jane@mail.com')");
//        statement.execute("INSERT INTO contacts (name, phone, email) VALUES('Fido', 65656654, 'fido@mail.com')");
//           statement.execute("UPDATE contacts SET phone=78787 WHERE name='Joe'");
//           statement.execute("DELETE FROM contacts WHERE name='Joe'");


            while (resultSet.next()) {
                String name = resultSet.getString("first_name");
                String mail = resultSet.getString("last_name");
                int phone = resultSet.getInt("income");
                System.out.println(name + " " + phone + " " + mail);
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
