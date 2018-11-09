package kyu5;

import kyu3.Fibonacci;

import java.math.BigInteger;

//  Task description on https://www.codewars.com/kata/559a28007caad2ac4e000083/
//  Time complexity is O(log n)
//  Space complexity is O(1)
public class SumFct {
    public static BigInteger perimeter(BigInteger n) {
        BigInteger res = Fibonacci.fib(BigInteger.valueOf(n.intValue() + 3))
                .subtract(BigInteger.ONE)
                .shiftLeft(2);

        return res;
    }
}
