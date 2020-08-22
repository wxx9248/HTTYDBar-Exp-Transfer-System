import com.httydbar.exptransfer.dao.IDatabaseDAOWithAccount;
import com.httydbar.exptransfer.dao.impl.DatabaseDAOFactory;
import com.httydbar.exptransfer.util.impl.Account;
import com.httydbar.exptransfer.util.impl.Database;
import com.httydbar.exptransfer.util.impl.SQLParamManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestDAO implements ITestClass
{
    public void testMain()
    {
        Database database = new Database("com.mysql.cj.jdbc.Driver",
                                         "jdbc:mysql://192.168.92.2:3306",
                                         "toothle2_newberk",
                                         "?useUnicode=true&characterEncoding=utf-8");
        Account account = new Account("toothle2_toothless", "toothlesshiccup2020");
        DatabaseDAOFactory factory = new DatabaseDAOFactory(database);
        IDatabaseDAOWithAccount databaseDAO = factory.getInstance(account);
        SQLParamManager sqlParamManager = new SQLParamManager();
        
        try
        {
            databaseDAO.connect();
            
            ResultSet rs = databaseDAO.doQuery(databaseDAO.getPreparedStatement("SELECT uid, username FROM pre_common_member;"));
            
            while (rs.next())
            {
                System.out.println("ID: " + rs.getInt("uid") + ", Username: " + rs.getString("username"));
            }
            
            PreparedStatement preparedStatement = databaseDAO.getPreparedStatement("INSERT INTO wxx9248_test (id, data) VALUE (?, ?);");
            sqlParamManager.addParam(1);
            sqlParamManager.addParam("Hello world");
            sqlParamManager.populatePreparedStatement(preparedStatement);
            
            int affectedRows = databaseDAO.doUpdate(preparedStatement);
            
            System.out.println(affectedRows);
            
            databaseDAO.close();
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
