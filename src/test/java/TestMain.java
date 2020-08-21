public class TestMain
{
    private static ITestClass[] testClasses = {
            //new TestDAO(),
            new TestService(),
    };
    
    private TestMain() {}
    
    public static void main(String[] args)
    {
        for (ITestClass testClass : testClasses)
        {
            testClass.testMain();
        }
    }
}
