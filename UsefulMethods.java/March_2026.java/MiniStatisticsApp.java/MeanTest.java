import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeanTest{


    @Test
    public void checkIfMeanIsCorrect(){
 
        int indexCounter =0;

        int sumOfNumbers =0;

        int mean =0;

        int [] numbers ={1, 2, 3, 4, 6};

        while (indexCounter <=numbers.length){
            sumOfNumbers +=numbers[indexCounter];
            indexCounter++;
        }

        mean =sumOfNumbers /numbers.length;

        int actualmeanValue =mean;

        int expectedmeanValue =3;

        assertEquals(actualmeanValue, expectedmeanValue);

    }

}
