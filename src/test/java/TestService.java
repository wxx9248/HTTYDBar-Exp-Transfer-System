import com.httydbar.exptransfer.service.UsernamePasswordVerificationService;
import com.httydbar.exptransfer.util.Account;
import com.httydbar.exptransfer.util.ConfigManager;

public class TestService implements ITestClass
{
    @Override
    public void testMain()
    {
        try
        {
            ConfigManager.loadJSONConfigFromFile("E:\\config.json");
            ConfigManager.parseConfiguration();
    
            System.out.println(UsernamePasswordVerificationService.verify(new Account("wxx9248", "33baaed5bf5d7b3944af9b0566e218d3")));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
