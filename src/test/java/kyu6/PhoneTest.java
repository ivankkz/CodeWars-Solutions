package kyu6;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PhoneTest {
    @Test
    public void test() {
        assertEquals("(123) 456-7890", Phone.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}