import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BikeSystemTest {

    @Test
    public void CheckIfBikeIsOn() {
        assertEquals(1, BikeSystem.turnOnBike(0));
    }

    @Test
    public void CheckIfBikeIsOff() {
        assertEquals(0, BikeSystem.turnOffBike(1));
    }

    @Test
    public void testThatSpeedIncreasedByGearValue_WhenBikeIsOn() {

        assertEquals(1, BikeSystem.accelerate(1, 0));
        assertEquals(23, BikeSystem.accelerate(1, 21));
        assertEquals(34, BikeSystem.accelerate(1, 31));
        assertEquals(45, BikeSystem.accelerate(1, 41));
    } 

    @Test
    public void testThatAccelerateMethodReturnsAnError_WhenBikeIsOff() {
        // Must pass 0 for status to test "Off" logic
        assertEquals(-1, BikeSystem.accelerate(0, 32));
    } 

    @Test
    public void testThatSpeedDecreasesByGearValue_WhenBikeIsOn() {

        assertEquals(19, BikeSystem.deccelerate(1, 20));
        assertEquals(28, BikeSystem.deccelerate(1, 30));
        assertEquals(37, BikeSystem.deccelerate(1, 40));
        assertEquals(46, BikeSystem.deccelerate(1, 50));
    } 

    @Test
    public void testThatDecreaseMethodReturnsAnError_WhenBikeIsOff() {
        assertEquals(-1, BikeSystem.deccelerate(0, 32));
    }

    @Test
    public void testThatGearSpeedIsCategorizedProperly() {
        assertEquals(4, BikeSystem.identifyCurrentGearSpeed(1, 78));
        assertEquals(3, BikeSystem.identifyCurrentGearSpeed(1, 32));
        assertEquals(2, BikeSystem.identifyCurrentGearSpeed(1, 27));
        assertEquals(1, BikeSystem.identifyCurrentGearSpeed(1, 3));
    }
}

