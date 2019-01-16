package kyu3;

import java.math.BigInteger;

//  Task description on https://www.codewars.com/kata/53d40c1e2f13e331fc000c26
//  Time complexity is O(log n)
//  Space complexity is O(1)
public final class Fibonacci {
    public static BigInteger fib(BigInteger n) {
        int count = n.intValue();
        Matrix2x2 res;

        if (count == 0)
            return BigInteger.ZERO;

        res = new Matrix2x2(BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO)
                .pow(Math.abs(count) - 1);

        return (n.signum() != -1) || (count % 2 != 0) ? res.getM00() : res.getM00().negate();
    }
}

final class Matrix2x2 {
    private BigInteger m00, m01, m10, m11;

    public Matrix2x2(BigInteger M00, BigInteger M01, BigInteger M10, BigInteger M11) {
        this.m00 = M00;
        this.m01 = M01;
        this.m10 = M10;
        this.m11 = M11;
    }

    public Matrix2x2 multiply(Matrix2x2 B) {
        BigInteger M00 = this.m00.multiply(B.m00).add(this.m01.multiply(B.m10));
        BigInteger M01 = this.m00.multiply(B.m01).add(this.m01.multiply(B.m11));
        BigInteger M10 = this.m10.multiply(B.m00).add(this.m11.multiply(B.m10));
        BigInteger M11 = this.m10.multiply(B.m01).add(this.m11.multiply(B.m11));
        return new Matrix2x2(M00, M01, M10, M11);
    }

    public Matrix2x2 pow(int n) {
        Matrix2x2 res = new Matrix2x2(BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE);
        Matrix2x2 temp = this;
        while (n > 0) {
            if ((n & 1) == 1)
                res = res.multiply(temp);
            if (n > 1)  // skip last multiplication for performance
                temp = temp.multiply(temp);
            n >>= 1;
        }
        return res;
    }

    public BigInteger getM00() {
        return this.m00;
    }
}