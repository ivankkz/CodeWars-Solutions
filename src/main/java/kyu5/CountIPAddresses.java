package kyu5;

//  Task description on https://www.codewars.com/kata/count-ip-addresses
public class CountIPAddresses {
    public static long ipsBetween(String start, String end) {
        return convertIPToLong(end) - convertIPToLong(start);
    }

    public static long convertIPToLong(String ip) {
        long res = 0l;

        for (String s : ip.split("\\.")) {
            res <<= 8;
            res += Long.valueOf(s);
        }

        return res;
    }
}
