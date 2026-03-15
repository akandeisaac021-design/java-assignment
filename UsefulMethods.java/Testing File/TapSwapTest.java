import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TapSwapTest{

    @Test
    public void testTapSwap(int[] numbers){
        TapSwap swapper =new TapSwap();

        int [] actual =swapper.tapSwapper();
        int [] expected =numbers;

        assertEquals(actual,expected);

    }
}
