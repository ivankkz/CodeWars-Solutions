package kyu4;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NumberTest {
    @Test
    public void basicTests() {
        assertEquals(21, Number.nextBiggerNumber(12));
        assertEquals(531, Number.nextBiggerNumber(513));
        assertEquals(2071, Number.nextBiggerNumber(2017));
        assertEquals(441, Number.nextBiggerNumber(414));
        assertEquals(414, Number.nextBiggerNumber(144));
        assertEquals(150238, Number.nextBiggerNumber(138520));
        assertEquals(414, Number.nextBiggerNumber(144));
        assertEquals(414, Number.nextBiggerNumber(144));
    }
}
