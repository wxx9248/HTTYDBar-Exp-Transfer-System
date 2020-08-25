import com.httydbar.exptransfer.service.ExpMigrationService;
import com.httydbar.exptransfer.service.UsernamePasswordVerificationService;
import com.httydbar.exptransfer.util.impl.Account;
import com.httydbar.exptransfer.util.impl.ConfigManager;
import com.httydbar.exptransfer.util.impl.ExtendedAccount;

public class TestService implements ITestClass
{
    @Override
    public void testMain()
    {
        try
        {
            ConfigManager.loadJSONConfigFromFile("E:\\config.json");
            ConfigManager.parseConfiguration();
            
            Account account = new Account("wxx9248", "33baaed5bf5d7b3944af9b0566e218d2");
            
            System.out.println(UsernamePasswordVerificationService.verify(account));
            
            ExtendedAccount extendedAccount = new ExtendedAccount(account, "wxx9248",
                                                                  "KKEIdr17LsakZ1g5Y9gFUNp2qRe+qhKlVRIMB4YDUsNnY4hsqNt0wq4rBTpDAbvW3/aJwEoNrjj9w6AR1Eyw57eOx/zU2LmBzx8bmYkLJzTDpKSqltzs1/1WZJ2v3vfbciw8cpvy8iOtXyzKFc9rfD6ArZERAFy/OhIMp497o8cZ97Opo04m8dVMKqztrXhXSGQfLFkd/5KGvBL3JY3rw6qZvSbBYcQ10jhrLfwXNlVzKcjTubGNOmk+bUKZeYkWYnpyY0DEfwVxmIFaEk/lknqIwnvBPXz0gYtpWBW54scP1MtxDhfMfoJd37aTTTcQlp2Ae7Grk49XhtDl4u9RdZaZU6M7zRsV7Y07TdKEfl+WwgALbdJ7Nb/gu7hUcCiwXz7KMUN+cHsX3IQnLrWB6H6aTvMoiA4W5NX0dSNuABHE/+6ipUzLHc6osqSLEXyxD0hTwQxGIdgEuaRxZiKD9WK1lkzYP0U0dyp0Mb0akTeRqHMA0Xu5X88S2cmNmAMecfdloIenBCdO61s4PBX7Kbt+qCp78bYrxcLHQRGwW03lugwv/vxmbIjnmWxRNIdx6/r5cTexfhHp8GysF8yH36kX52TjzX/7P2bMUJUGLGgQh4oOSSQ38dLnujGnXqbMZFJ0FyvWIaS/bZz+te8R3qTLowmKHSRWvP7Ak8OzlOs=",
                                                                  "OeIoOSpcXpKDFJTRQcHN4ku7xc1n+o8VdWFdh8rWPDttX3hc84rj47jFEErbl6tOZCLsqo7GhlYSnuaLbWAzQBrFhsdSfPOx4Eos6WvEbhpbCoMTw4aMFTwumOUHR+0v7jUqhcPjyk6hr51zfj20fAJVh8YYMc6wS7ArWvDcm0fj8rI6wxMGkvAc8kwYy5sum3VIrAA2g9xHcUbSJrQkTnUTAUQbFX1LHAMuwo/s5aupX0N+gYwJLtHywpB+XmzVDiqgHryrAuFMDyDiLzOWBGpgi0hEZhpuPE40CDWsGwMjTgd5T+thW/inKPgHe92hMASZ7d2A9oSKC0qfa+m6+bKf4LpoqZ1ubzaA+h2Ha3sSdzdd7exJokuL00WxzdW+i8WY2tPZLdHRyx2rYQZ7Qa+H7DFGYJzAM16TdsiOXK8YariAiKRxKyGhI5P6nKX/EQFtZTjQuLQ6ecoZIRSGA1sIPaCX4QQ0tJoxXKPFAfXpO8MTu8sv98oKGO8pylMRUUjCMBI0MkLFdfzRGHO8D+P/45OSeDd32QaZG0O8xmngaiwk2h9rW950gDJ4Ts55Fb9+wldW3hRT8UkvsUU5bLtGlVKAN6zYxV/bYGa3Pl4UPz2kZrSmE9Yin1Q261+1mU+65cYSjrA5Ml3WCJl+V7WtQ6PLHx658Oj6VfeQ3eE=");
            
            System.out.println(ExpMigrationService.migrate(extendedAccount));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
