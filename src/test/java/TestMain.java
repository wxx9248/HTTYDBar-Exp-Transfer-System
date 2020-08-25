public class TestMain
{
    private static final ITestClass[] testClasses = {
            new TestAPI()
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
