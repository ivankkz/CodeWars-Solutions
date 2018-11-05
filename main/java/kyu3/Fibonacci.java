package kyu3;

import java.math.BigInteger;

//  Task description on https://www.codewars.com/kata/53d40c1e2f13e331fc000c26
//  Time complexity is O(log n)
//  Space complexity is O(1)
public class Fibonacci {
    public static BigInteger fib(BigInteger n) {
        int count = Math.abs(n.intValue()) - 1; // because |n| < 2^32 - 1
        boolean isPositive = (n.signum() != -1) || (count % 2 == 0);
        BigInteger[][] a = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        BigInteger[][] res = {{BigInteger.ONE, BigInteger.ZERO}, {BigInteger.ZERO, BigInteger.ONE}};

        if (n.signum() == 0)
            return BigInteger.ZERO;

        while (count > 0) {
            if (count % 2 == 1)
                res = multiplyMatrix(res, a);
            if (count != 1)  // skip last multiplication
                a = multiplyMatrix(a, a);
            count >>= 1;
        }

        return (isPositive) ? res[0][0] : res[0][0].negate();
    }

    public static BigInteger[][] multiplyMatrix(BigInteger[][] A, BigInteger[][] B) {
        int aRows = A.length;
        int bRows = B.length;
        int bColumns = B[0].length;
        BigInteger[][] res = new BigInteger[aRows][bColumns];

        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                for (int k = 0; k < bRows; k++) {
                    res[i][j] = (res[i][j] == null) ? A[i][k].multiply(B[k][j]) : res[i][j].add(A[i][k].multiply(B[k][j]));
                }
            }
        }

        return res;
    }
}