package kyu5;

//  Task description on https://www.codewars.com/kata/number-of-trailing-zeros-of-n
public class Factorial {
    public static int zeros(int n) {
        int count = 0;

        while (n >= 5) {
            n /= 5;
            count += n;
        }

        return count;
    }
}
