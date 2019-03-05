package kyu5;

import java.util.*;

public class FactDecom {
    public static String decomp(int n) {
        Map<Integer, Integer> numFactors = new TreeMap<>();
        Integer[] primeNumbers = findPrimeNumbers((int) Math.floor(Math.sqrt(n)));

        for (int i = 2; i <= n; i++) {
            int checkNum = i;
            for (int j = 0; j < primeNumbers.length; j++) {
                int checkDivisor = primeNumbers[j];
                if (checkNum < checkDivisor)
                    break;

                while (checkNum > 1) {
                    if (checkNum % checkDivisor == 0) {
                        addDivisorToFactors(checkDivisor, numFactors);
                        checkNum /= checkDivisor;
                    } else
                        break;
                }
            }

            if (checkNum > 1)
                addDivisorToFactors(checkNum, numFactors);
        }


        return createFactorialDecomposition(numFactors);
    }

    private static Integer[] findPrimeNumbers(int limit) {
        int[] allNumbers = new int[limit + 1];
        int sqrtLimit = (int) Math.sqrt(limit);
        ArrayList<Integer> primeNumbers = new ArrayList<>();

        for (int i = 2; i < allNumbers.length; i++) {
            allNumbers[i] = 1;
        }

        for (int i = 2; i <= sqrtLimit; i++) {
            if (allNumbers[i] == 1) {
                for (int j = i * i; j <= limit; j += i) {
                    allNumbers[j] = 0;
                }
            }
        }
        for (int i = 0; i < allNumbers.length; i++) {
            if (allNumbers[i] == 1) {
                primeNumbers.add(i);
            }
        }

        return primeNumbers.toArray(new Integer[primeNumbers.size()]);
    }

    private static void addDivisorToFactors(int divisor, Map<Integer, Integer> numFactors) {
        if (numFactors.containsKey(divisor))
            numFactors.replace(divisor, numFactors.get(divisor) + 1);
        else
            numFactors.put(divisor, 1);
    }

    private static String createFactorialDecomposition(Map<Integer, Integer> numFactors) {
        StringBuffer res = new StringBuffer();

        for (Integer divisor : numFactors.keySet()) {
            Integer count = numFactors.get(divisor);

            res.append(divisor.toString());
            if (count > 1)
                res.append("^").append(count.toString());
            res.append(" * ");
        }
        res.setLength(res.length() - 3);
        return res.toString();
    }
}
