package unittest;

import org.junit.Assert;
import org.junit.Test;

public class UnitTestTest {

    @Test
    public void test() {
        Assert.assertEquals("both values should be same", 20, 20);
    }

    @Test
    public void test2() {
        Assert.assertEquals("both values should be same", 20, 20);
    }


    @Test
    public void testPrintMessage() {
    String hello = "Hello World";
        System.out.println("testPrintMessage is executing");
        Assert.assertNotNull(hello);
        Assert.assertEquals("Hello World", hello);
    }
}