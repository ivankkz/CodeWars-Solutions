package kyu5;

import java.util.Arrays;

public class CountIPAddresses {
    public static long ipsBetween(String start, String end) {
        long[] startArr = Arrays.stream(start.split("\\.")).mapToLong(Long::parseLong).toArray();
        long[] endArr = Arrays.stream(end.split("\\.")).mapToLong(Long::parseLong).toArray();
        long startLong = 0l;
        long endLong= 0l;

        for (int i = 0; i < startArr.length; i++) {
            startLong <<= 8;
            endLong <<= 8;
            startLong |= startArr[i];
            endLong |= endArr[i];
        }

        return endLong - startLong;
    }
}
