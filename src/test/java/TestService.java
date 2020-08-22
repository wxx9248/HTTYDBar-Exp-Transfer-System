import com.httydbar.exptransfer.service.UsernamePasswordVerificationService;
import com.httydbar.exptransfer.util.impl.Account;
import com.httydbar.exptransfer.util.impl.ConfigManager;

public class TestService implements ITestClass
{
    @Override
    public void testMain()
    {
        try
        {
            ConfigManager.loadJSONConfigFromFile("E:\\config.json");
            ConfigManager.parseConfiguration();
            
            System.out.println(UsernamePasswordVerificationService.verify(new Account("暗纹z叶子", "f5c235a6d490b2c89d6eca5a70b940a1")));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
