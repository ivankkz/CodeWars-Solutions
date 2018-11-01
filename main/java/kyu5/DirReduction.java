package kyu5;

import java.util.LinkedList;

//  Task description on https://www.codewars.com/kata/550f22f4d758534c1100025a
public class DirReduction {
    private static final String NORTH = "NORTH";
    private static final String SOUTH = "SOUTH";
    private static final String WEST = "WEST";
    private static final String EAST = "EAST";

    public static String[] dirReduc(String[] arr) {
        LinkedList<Integer> resInt = new LinkedList<>();
        int[] arrInt = new int[arr.length];
        String[] resStr;
        int i;

        for (i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case NORTH:
                    arrInt[i] = -1;
                    break;
                case SOUTH:
                    arrInt[i] = +1;
                    break;
                case WEST:
                    arrInt[i] = -2;
                    break;
                case EAST:
                    arrInt[i] = +2;
                    break;
                default:
                    throw new IllegalArgumentException("Data is not correct");
            }
        }

        for (i = 0; i < arrInt.length; i++) {
            if (resInt.size() == 0 || resInt.getLast() + arrInt[i] != 0)
                resInt.add(arrInt[i]);
            else
                resInt.removeLast();
        }

        resStr = new String[resInt.size()];

        i = 0;
        for (Integer elem : resInt) {
            switch (elem) {
                case -1:
                    resStr[i] = NORTH;
                    break;
                case +1:
                    resStr[i] = SOUTH;
                    break;
                case -2:
                    resStr[i] = WEST;
                    break;
                case +2:
                    resStr[i] = EAST;
                    break;
            }
            i++;
        }

        return resStr;
    }
}

