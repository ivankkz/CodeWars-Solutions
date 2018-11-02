package kyu4;

import java.util.Arrays;

//  Task description on https://www.codewars.com/kata/55983863da40caa2c900004e
public class Number {
    public static long nextBiggerNumber(long n) {
        int[] digits = Long.toString(n).chars().map(c -> c - '0').toArray();
        int i = digits.length - 1;
        int[] changingDigits;

        do {
            i--;
        } while (i >= 0 && digits[i] >= digits[i + 1]);

        if (i <= -1)
            return -1;

        changingDigits = Arrays.copyOfRange(digits, i + 1, digits.length);
        Arrays.sort(changingDigits);

        for (int j = 0; j < changingDigits.length; j++) {
            if (changingDigits[j] > digits[i]) {
                int temp = digits[i];
                digits[i] = changingDigits[j];
                changingDigits[j] = temp;
                Arrays.sort(changingDigits);
                break;
            }
        }
        System.arraycopy(changingDigits, 0, digits, i + 1, changingDigits.length);

        return new Long(Arrays.toString(digits).replaceAll("\\[|\\]|,|\\s", ""));
    }
}
