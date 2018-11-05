package kyu6;

import java.util.Arrays;

//  Task description on https://www.codewars.com/kata/54da5a58ea159efa38000836
public class FindOdd {
    public static int findIt(int[] a) {
        int i = 0;

        Arrays.sort(a);
        while (i < a.length) {
            do {
                i++;
            } while (i < a.length && a[i - 1] == a[i]);

            if (i % 2 == 1) return a[i - 1];
        }

        return 0;
    }
}