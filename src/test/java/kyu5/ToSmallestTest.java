package kyu5;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class ToSmallestTest {

    @Test
    @Parameters(source = ToSmallestData.class, method = "smallest")
    public void smallest(long n, long[] expected) {
        assertArrayEquals(expected, ToSmallest.smallest(n));
    }
}
