package kyu5;

public class ToSmallest {
    public static long[] smallest(long n) {
        long[] res1 = moveFirst(n);
        long[] res2 = moveSmallToStart(n);

        return (res1[0] <= res2[0]) ? res1 : res2;
    }

    public static long[] moveFirst(long n) {
        char[] digits = Long.toString(n).toCharArray();
        char num = digits[0];

        for (int j = 1; j < digits.length; j++) {
            boolean swap = false;

            if (digits[j] > num) {
                swap = true;
                j--;
            } else if (j == digits.length - 1) {
                swap = true;
            }

            if (swap) {
                while (j > 0 && digits[j] == num)
                    j--;

                for (int k = 0; k < j; k++) {
                    digits[k] = digits[k + 1];
                }
                digits[j] = num;
                return new long[]{Long.parseLong(new String(digits)), 0, j};
            }
        }

        return new long[]{Long.MAX_VALUE, 0, 0};
    }

    public static long[] moveSmallToStart(long n) {
        char[] digits = Long.toString(n).toCharArray();

        for (int i = 0; i < digits.length - 1; i++) {
            char num = digits[i];
            int index = i;

            for (int j = i + 1; j < digits.length; j++) {
                if (num > digits[j]) {
                    num = digits[j];
                    index = j;
                } else if (num == digits[j]) {
                    if (digits[j - 1] != digits[j]) {
                        num = digits[j];
                        index = j;
                    }
                }
            }

            if (index != i) {
                num = digits[index];
                for (int j = index; j > i; j--) {
                    digits[j] = digits[j - 1];
                }
                digits[i] = num;

                return new long[]{Long.parseLong(new String(digits)), index, i};
            }
        }

        return new long[]{Long.MAX_VALUE, 0, 0};
    }
}