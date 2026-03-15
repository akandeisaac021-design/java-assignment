import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JavaCupcakesTest{

    @Test
    public void predicateTest(){

    int [] numbers ={2,5,7,1,6,9};

    boolean [] expected ={true,false,false,false,true,false};

    boolean [] actual ={true,false,false,false,true,false};

    assertEquals(expected, actual);
    }


    @Test
    public void checkThatDoubleValueIsAccurate](){

    int [] numbers ={2,5,7,1,6,9};

    int [] expected ={2,5,7,1,6,9,4,10,14,2,12,18};

    int [] actual ={2,5,7,1,6,9,4,10,14,2,12,18};

    assertEquals(expected, actual);
    }






}
