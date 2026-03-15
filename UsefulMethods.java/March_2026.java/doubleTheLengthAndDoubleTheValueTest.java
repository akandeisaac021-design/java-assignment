import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class doubleTheLengthAndDoubleTheValueTest{

    @Test
    public void checkThatDoubleValueIsAccurate](){

    int [] numbers ={2,5,7,1,6,9};

    int [] expected ={2,5,7,1,6,9,4,10,14,2,12,18};

    int [] actual =JavaCupcakes.doubleTheLengthAndDoubleTheValue(numbers);

    assertEquals(expected, actual);
    }

}
