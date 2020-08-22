import com.httydbar.exptransfer.service.UsernamePasswordVerificationService;
import com.httydbar.exptransfer.util.ICipher;
import com.httydbar.exptransfer.util.impl.Account;
import com.httydbar.exptransfer.util.impl.ConfigManager;
import com.httydbar.exptransfer.util.impl.RSACipher;
import sun.security.krb5.Config;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TestRSA implements ITestClass
{
    @Override
    public void testMain()
    {
        try
        {
            ConfigManager.loadJSONConfigFromFile("E:\\config.json");
            ConfigManager.parseConfiguration();
            
            System.out.println(ConfigManager.getPrivateRSAKey());
            System.out.println(ConfigManager.getPublicRSAKey());
            
            String test = "Hello, hello, 单元测试~";
    
            ICipher cipher = RSACipher.getInstance(ConfigManager.getPrivateRSAKey(), ConfigManager.getPublicRSAKey());
            
            System.out.println(new String(cipher.decrypt(cipher.encrypt(test.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
