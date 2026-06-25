import groupFour.HugeInteger;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;


public class HugeIntegerTest {


    @Test
    public void testForMethodParse(){
        String number = "2864893973";
        HugeInteger hugeInteger = new HugeInteger();

        int [] actual = hugeInteger.parse(number);
        int [] expected = {2, 8, 6, 4, 8, 9, 3, 9, 7, 3,};

        assertArrayEquals(actual, expected);
    }


    @Test
    public void testForToStringMethod(){
        int [] numbers = {2, 8, 6, 4, 8, 9, 3, 9, 7, 3,};
        HugeInteger hugeInteger = new HugeInteger();

        String actual = hugeInteger.toString(numbers);
        String expected = "[2, 8, 6, 4, 8, 9, 3, 9, 7, 3]";

        assertEquals(actual, expected);
    }
}
