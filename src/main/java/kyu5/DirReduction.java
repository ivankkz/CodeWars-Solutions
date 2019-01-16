package kyu5;

import java.util.Stack;

//  Task description on https://www.codewars.com/kata/550f22f4d758534c1100025a
public class DirReduction {
    private static final String BAD_FORMAT = "NORTHSOUTHNORTH WESTEASTWEST";
//    private static final String BAD_FORMAT = "NORTHSOUTH SOUTHNORTH WESTEAST EASTWEST";

    public static String[] dirReduc(String[] arr) {
        Stack<String> resStack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (resStack.isEmpty() || !BAD_FORMAT.contains(resStack.peek().concat(arr[i])))
                resStack.push(arr[i]);
            else
                resStack.pop();
        }

        return resStack.stream().toArray(String[]::new);
    }
}

