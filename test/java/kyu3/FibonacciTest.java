package kyu3;

import java.math.BigInteger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void testPositiveFib() {
        testFib(0, 0);
        testFib(1, 1);
        testFib(1, 2);
        testFib(610, 15);
        testFib(196418, 27);
        testFib(9227465, 35);
    }

    @Test
    public void testNegativeFib() {
        testFib(1, -1);
        testFib(-3, -4);
        testFib(5, -5);
        testFib(-6765, -20);
        testFib(1134903170, -45);
        testFib(-1836311903, -46);
    }

    private static void testFib(long expected, long input) {
        BigInteger found;
        try {
            found = Fibonacci.fib(BigInteger.valueOf(input));
        } catch (Throwable e) {
            throw new AssertionError("exception during test: " + e, e);
        }
        assertEquals(BigInteger.valueOf(expected), found);
    }

}
