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
            
            String bduss  = "0FSSXJ-c2p5VjZWeVRXQTA4dGZSOUF6aXNnem1jTWVqT25YVjNJS051TXVRMXBmRUFBQUFBJCQAAAAAAAAAAAEAAAA6Bpsnd3h4OTI0OAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAC62Ml8utjJfY";
            String sToken = "588374d42483f20eee73723ee7b0684b3d6f66b0bea4a730fa89672c25248f14";
            
            String bduss2  = "EhDYmhGV29SYjdTSjkyc1BOZ1YzZHo1ZlhTakVzQ0ZyLVVRTDFsQXhnMlVIV3hmRVFBQUFBJCQAAAAAAAAAAAEAAABfkKVLztq-1lJpb7bOAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAJSQRF-UkERfd";
            String sToken2 = "637a1e4822628692df04397ccd8851e9ab8ed3bbb8764026e81551e4ad189907";
            
            String bduss3  = "9SZ2d1UXF6bUNhbkpoLW0xWUp6RXkzNW13WGpGWEFHVHdPeVlTVFZLZDZlMjFmRVFBQUFBJCQAAAAAAAAAAAEAAACmSrEksODW98jO0NXH2AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHruRV967kVfSW";
            String sToken3 = "4f37f6d3d0cb885f0f5cc15e50deebe6b30cb1bf090dfe09dac9c3ea427edbbc";
            
            List<MyTB>          list = api.getMyLikedTB(bduss3, sToken3);
            Map<String, Object> map  = api.getUserInfo(bduss3, sToken3);
            
            for (MyTB myTB : list)
            {
                System.out.println(myTB.getTbName() + " " + myTB.getEx());
            }
            System.out.println(map);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
