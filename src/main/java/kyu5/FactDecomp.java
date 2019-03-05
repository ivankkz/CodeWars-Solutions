package kyu5;

import java.util.*;

/*
Benchmark                 (num)  Mode  Cnt   Score   Error  Units
BenchmarkTest.decomp     100000  avgt    2   0,047           s/op
BenchmarkTest.decomp    1000000  avgt    2   0,872           s/op
BenchmarkTest.decomp   10000000  avgt    2  16,127           s/op
BenchmarkTest.decomp2    100000  avgt    2   0,036           s/op
BenchmarkTest.decomp2   1000000  avgt    2   0,539           s/op
BenchmarkTest.decomp2  10000000  avgt    2   9,966           s/op
BenchmarkTest.decomp3    100000  avgt    2   0,044           s/op
BenchmarkTest.decomp3   1000000  avgt    2   1,059           s/op
BenchmarkTest.decomp3  10000000  avgt    2  26,802           s/op
*/
public class FactDecomp {
    public static String decomp(int n) {
        TreeMap<Integer, Integer> numFactors = new TreeMap<>();
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

    public static String decomp2(int n) {
        DivisorsOfNumber[] divisors = new DivisorsOfNumber[n + 1];
        Integer[] primeNumbers = findPrimeNumbers((int) Math.floor(Math.sqrt(n)));

        for (int i = 2; i <= n; i++) {
            int checkNum = i;
            int checkSqrtNum = (int) Math.sqrt(i);
            int j = 0;
            boolean findDivisor = false;

            while (j < primeNumbers.length && checkSqrtNum >= primeNumbers[j]) {
                int checkDivisor = primeNumbers[j];

                if (checkNum % checkDivisor == 0) {
                    if (checkNum / checkDivisor == 1)
                        divisors[checkNum] = new DivisorsOfNumber(checkDivisor, null);
                    else
                        divisors[checkNum] = new DivisorsOfNumber(checkDivisor, divisors[checkNum / checkDivisor]);
                    findDivisor = true;
                    break;
                }
                j++;
            }

            if (!findDivisor)
                divisors[checkNum] = new DivisorsOfNumber(checkNum, null);
        }

        return createFactorialDecomposition(countNumFactors(divisors));
    }

    public static String decomp3(int n) {
        int[] exponentsOfPrimes = new int[n + 1];
        while (n > 1) {
            int x = n--;
            for (int i = 2; i <= Math.sqrt(x); i++)
                if (x % i == 0) {
                    x /= i;
                    exponentsOfPrimes[i]++;
                    i = 1;
                }
            exponentsOfPrimes[x]++;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 2; i < exponentsOfPrimes.length; i++) {
            if (exponentsOfPrimes[i] == 0) continue;
            if (exponentsOfPrimes[i] == 1) result.append(i + " * ");
            if (exponentsOfPrimes[i] > 1) result.append(i + "^" + exponentsOfPrimes[i] + " * ");
        }
        return result.substring(0, result.length() - 3);
    }

    static class DivisorsOfNumber {
        private int basic;
        private DivisorsOfNumber parent;

        public DivisorsOfNumber(int basic, DivisorsOfNumber parent) {
            this.basic = basic;
            this.parent = parent;
        }
    }

    private static TreeMap<Integer, Integer> countNumFactors(DivisorsOfNumber[] divisors) {
        TreeMap<Integer, Integer> numFactors = new TreeMap<>();

        for (int i = 0; i < divisors.length; i++) {
            if (divisors[i] != null) {
                DivisorsOfNumber temp = divisors[i];

                while (temp != null) {
                    addDivisorToFactors(temp.basic, numFactors);
                    temp = temp.parent;
                }
            }
        }

        return numFactors;
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

    private static void addDivisorToFactors(int divisor, TreeMap<Integer, Integer> numFactors) {
        if (numFactors.containsKey(divisor))
            numFactors.replace(divisor, numFactors.get(divisor) + 1);
        else
            numFactors.put(divisor, 1);
    }

    private static String createFactorialDecomposition(TreeMap<Integer, Integer> numFactors) {
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
