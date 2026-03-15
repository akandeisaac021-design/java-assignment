import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvenIndexlettersTest{


    @Test
    public void checkIfEvenIndexLettersIsAccurate(){

    String name ="Isaac";    

    String actual =EvenIndexletters.findMyEvenIndexLetters(name);

    String expected ="sa";

    assertEquals(actual, expected);


    }



}
