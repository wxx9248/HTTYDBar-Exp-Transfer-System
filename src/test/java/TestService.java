import com.httydbar.exptransfer.service.UsernamePasswordVerificationService;
import com.httydbar.exptransfer.util.Account;
import com.httydbar.exptransfer.util.ConfigManager;

public class TestService implements ITestClass
{
    public static final String CONFIG = "{\n" +
                                        "   \"database\":{\n" +
                                        "      \"driver\":\"com.mysql.cj.jdbc.Driver\",\n" +
                                        "      \"baseURL\":\"jdbc:mysql://192.168.92.2:3306\",\n" +
                                        "      \"name\":\"toothle2_newberk\",\n" +
                                        "      \"additionalParameters\":\"?useUnicode=true&characterEncoding=utf-8\",\n" +
                                        "      \"username\":\"toothle2_toothless\",\n" +
                                        "      \"password\":\"toothlesshiccup2020\"\n" +
                                        "   }\n" +
                                        "}";
    
    @Override
    public void testMain()
    {
        try
        {
            ConfigManager.loadJSONConfigFromString(CONFIG);
            ConfigManager.parseConfiguration();
    
            System.out.println(UsernamePasswordVerificationService.verify(new Account("暗纹z叶子", "f5c235a6d490b2c89d6eca5a70b940a1")));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
