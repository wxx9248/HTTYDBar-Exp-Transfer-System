import com.github.libsgh.tieba.api.TieBaApi;
import com.github.libsgh.tieba.model.MyTB;

import java.util.List;
import java.util.Map;

public class TestAPI implements ITestClass
{
    public void testMain()
    {
        try
        {
            TieBaApi api = new TieBaApi();
            
            List<MyTB>          list = api.getMyLikedTB("", "");
            Map<String, Object> map  = api.getUserInfo("", "");
            
            System.out.println(list);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
