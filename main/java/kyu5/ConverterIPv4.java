package kyu5;

//  Task description on https://www.codewars.com/kata/int32-to-ipv4
public class ConverterIPv4 {
    public static String longToIP(long ip) {
        long temp;
        long[] res = new long[4];

        for (int i = 0; i < res.length; i++) {
            temp = ip;
            ip >>= 8;
            ip <<= 8;
            res[res.length - i - 1] = temp - ip;
            ip >>= 8;
        }

        return res[0] + "." + res[1] + "." + res[2] + "." + res[3];
    }
}
