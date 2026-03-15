import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JavaCupcakesTest{

    @Test
    public void predicateTest(){

    int [] numbers ={2,5,7,1,6,9};

    boolean [] expected ={true,false,false,false,true,false};

    boolean [] actual =JavaCupcakes.checkIfNumberIsEven(numbers);

    assertEquals(expected, actual);
    }






}
