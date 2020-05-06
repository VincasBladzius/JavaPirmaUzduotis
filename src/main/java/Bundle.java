import java.sql.Statement;
import java.util.ArrayList;

public class Bundle {

    public ArrayList<QueriesClass> createBundle(Statement statement){
            ArrayList<QueriesClass> bundle = new ArrayList<>();
            bundle.add(new CreateDatabase(statement));
            bundle.add(new Subsidize(statement));
            bundle.add(new ShowProblematic(statement));
        return bundle;
    }
}
