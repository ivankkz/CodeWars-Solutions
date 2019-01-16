package kyu3;

//  Task description on https://www.codewars.com/kata/58c5577d61aefcf3ff000081/
public class RailFenceCipher {
    static String encode(String s, int n) {
        StringBuffer sb = new StringBuffer(s);
        int shift = (n == 1) ? 1 : 2 * (n - 1);
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < s.length(); j += shift) {
                sb.setCharAt(count++, s.charAt(j));
                if (j + shift - 2 * i < s.length() && i != 0 && i != n - 1) {
                    sb.setCharAt(count++, s.charAt(j + shift - 2 * i));
                }
            }
        }

        return new String(sb);
    }

    static String decode(String s, int n) {
        StringBuffer sb = new StringBuffer(s);
        int shift = (n == 1) ? 1 : 2 * (n - 1);
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < s.length(); j += shift) {
                sb.setCharAt(j, s.charAt(count++));
                if (j + shift - 2 * i < s.length() && i != 0 && i != n - 1) {
                    sb.setCharAt(j + shift - 2 * i, s.charAt(count++));
                }
            }
        }

        return new String(sb);
    }
}
