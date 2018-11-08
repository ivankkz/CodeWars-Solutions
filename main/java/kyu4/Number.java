package kyu4;

import java.util.Arrays;

//  Task description on https://www.codewars.com/kata/55983863da40caa2c900004e
public class Number {
    public static long nextBiggerNumber(long n) {
        char[] digits = Long.toString(n).toCharArray();
        int i = digits.length - 1;
        int j;

        do {
            i--;
        } while (i >= 0 && digits[i] >= digits[i + 1]);

        if (i <= -1)
            return -1;

        j = i;

        while (j + 1 < digits.length && digits[j + 1] > digits[i]) {
            j++;
        }

        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        Arrays.sort(digits, i + 1, digits.length);
        return Long.valueOf(new String(digits));
    }
}
