package kyu3;

import java.math.BigInteger;

//  Task description on https://www.codewars.com/kata/53d40c1e2f13e331fc000c26
//  Time complexity is O(log n)
//  Space complexity is O(1)
public class Fibonacci {
    public static BigInteger fib(BigInteger n) {
        int count = Math.abs(n.intValue()); // because |n| < 2^32 - 1
        boolean isPositive = (n.signum() != -1) || (count % 2 == 1);
        BigInteger[][] a = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        BigInteger[][] res = new BigInteger[1][];

        if (n.signum() == 0)
            return BigInteger.ZERO;

        while (count > 0) {
            if (count % 2 == 1)
                res = (res[0] == null) ? a.clone() : multiplyMatrix(res, a);
            if (count != 1)  // skip last multiplication
                a = multiplyMatrix(a, a);
            count >>= 1;
        }

        return (isPositive) ? res[0][1] : res[0][1].negate();
    }

    public static BigInteger[][] multiplyMatrix(BigInteger[][] A, BigInteger[][] B) {
        int aRows = A.length;
        int bRows = B.length;
        int aColumns = bRows; // = A[0].length;
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