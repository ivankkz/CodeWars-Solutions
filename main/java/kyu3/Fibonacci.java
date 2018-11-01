package kyu3;

import java.math.BigInteger;

//  Task description on https://www.codewars.com/kata/53d40c1e2f13e331fc000c26
//  Time complexity is O(n)
//  Space complexity is O(1)
public class Fibonacci {
    public static BigInteger fib(BigInteger n) {
        int count = n.intValue(); // because |n| < 2^32 - 1
        BigInteger now = BigInteger.ZERO;
        BigInteger next = BigInteger.ONE;
        BigInteger temp;

        if (count > 0) while (count != 0) {
            temp = next;
            next = next.add(now);
            now = temp;
            count--;
        }
        else while (count != 0) {
            temp = now;
            now = next.subtract(now);
            next = temp;
            count++;
        }

        return now;
    }

}
