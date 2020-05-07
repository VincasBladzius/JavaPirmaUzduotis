package piRmaUzduotis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

public class FirstTask {

    private static Connection connect = null;
    private static Statement statement = null;
    public static final String DB_NAME = "pandemic";
    public static final String url = "jdbc:mysql://localhost:3306/" + DB_NAME;
    public static final String user = "root", pass = "";
    public static final String driver = "com.mysql.cj.jdbc.Driver";

    public void loadFirstTask() {
        try {
            Class.forName(driver);
            connect = DriverManager.getConnection(url, user, pass);
            statement = connect.createStatement();
            Bundle bundle = new Bundle();
            PrintOut print = new PrintOut(statement);
            ArrayList<QueriesClass> bundlePack = bundle.createBundle(statement);
            for (QueriesClass query : bundlePack) {
                query.performAction();
                print.performAction();
            }
            statement.close();
            connect.close();
        } catch (Exception e) {
            StackTraceElement[] elements = e.getStackTrace();
            System.out.println(e + " at " + elements[elements.length - 1]);
        }//try
    }//main

}
