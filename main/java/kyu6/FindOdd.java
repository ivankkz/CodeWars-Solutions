package kyu6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//  Task description on https://www.codewars.com/kata/54da5a58ea159efa38000836
public class FindOdd {
    public static int findIt(int[] a) {
        Map<Integer, Integer> res = new HashMap<>();
        Integer[] aInt = Arrays.stream(a).boxed().toArray(Integer[]::new);

        for (int i = 0; i < aInt.length; i++) {
            if (res.containsKey(aInt[i]))
                res.put(aInt[i], res.get(aInt[i]) + 1);
            else
                res.put(aInt[i], 1);
        }

        for (Map.Entry<Integer, Integer> elem : res.entrySet()) {
            if (elem.getValue() % 2 == 1)
                return elem.getKey();
        }

        return 0;
    }
}