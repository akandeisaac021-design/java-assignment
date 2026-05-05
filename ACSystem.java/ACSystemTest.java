import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ACSystemTest{

    @Test
    public void CheckIfACIsOff(){assertEquals(0, ACSystem.putOffTheAC(1));}


    @Test
    public void CheckIfACIsOn(){assertEquals(1 ,ACSystem.putOnTheAC(0));}


    @Test
    public void checkIfTemperatureReduces(){assertEquals(30, ACSystem.decreaseTheaCTemperature(1, 31));}


    @Test
    public void checkThatTemperatureWillNotDecrease_WhenACIsOff(){assertEquals(-1,ACSystem.decreaseTheaCTemperature(0, 31));}

    
    @Test
    public void checkThatTemperatureWillNotDecrease_WhenACIsAlreadyAtMininumTemperature(){assertEquals(-1, ACSystem.decreaseTheaCTemperature(1, 16));}


    @Test
    public void checkThatTemperatureWillNotDecreaseTOMinimum_WhenACIsOff(){assertEquals(-1, ACSystem.DecreaseACToMinimumTemperature(0, 25));}

  
    @Test
    public void checkIfTemperatureDecreasesToTheLowest(){assertEquals(16, ACSystem.DecreaseACToMinimumTemperature(1, 25));}    

    
    @Test
    public void checkThatTemperatureWillNotDecreaseTOMinimum_WhenACIsAlreadyAtMininumTemperature(){assertEquals(-1, ACSystem.DecreaseACToMinimumTemperature(1, 16));}

     
    @Test
    public void checkIfTemperatureIncreases(){assertEquals(27, ACSystem.IncreaseTheaCTemperature(1, 26));}


    @Test
    public void checkIfTemperatureIncreases_WhenACIsOff(){assertEquals(-1, ACSystem.IncreaseTheaCTemperature(0, 31));}

    
    @Test
    public void checkIfTemperatureIncreases_WhenACIsAlreadyAtMaximumTemperature(){assertEquals(-1, ACSystem.IncreaseTheaCTemperature(1, 31));}


    @Test
    public void checkIfTemperatureIncreasesToTheHighest(){assertEquals(31, ACSystem.IncreaseACToMaximumTemperature(1, 25));}


    @Test
    public void checkIfTemperatureIncreasesToMaximum_WhenACIsOff(){assertEquals(-1, ACSystem.IncreaseACToMaximumTemperature(0, 25));}


    @Test
    public void checkIfTemperatureIncreasesToMaximum_WhenACIsAlreadyAtMaximumTemperature(){assertEquals(-1, ACSystem.IncreaseACToMaximumTemperature(1, 31));}


}
