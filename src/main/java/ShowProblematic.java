import java.sql.SQLException;
import java.sql.Statement;

public class ShowProblematic extends QueriesClass implements Delete{
    public ShowProblematic(Statement statement) {
        super(statement);
    }

    @Override
    public void delete(){
        try {
            super.getStatement().execute("DELETE FROM "
                    + TABLE_FOR_PERSONS +
                    " WHERE "
                    + INCOME + " > 400 ");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void performAction(){
        this.delete();
    }
}
