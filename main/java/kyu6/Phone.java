package kyu6;

import java.util.Arrays;

//  Task description on https://www.codewars.com/kata/525f50e3b73515a6db000b83
public class Phone {
    private static final String PHONE_FORMAT = "(%d%d%d) %d%d%d-%d%d%d%d";

    public static String createPhoneNumber(int[] numbers) {
        Integer[] nums = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        return String.format(PHONE_FORMAT, nums);
    }
}