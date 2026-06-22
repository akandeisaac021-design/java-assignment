import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class MidDayTaskTest{


    public void testThatArrayISquares(){

        int [] numbers ={1, 2, 3, 4, 5, 6, 7, 8, 9};

        int [] expected ={1, 4, 9, 16, 25, 36, 49, 64, 81};

        assertArrayEquals(expected, MidDayTask.squareArray(numbers) );

    }







}
