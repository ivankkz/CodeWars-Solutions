package kyu5;

import static junitparams.JUnitParamsRunner.$;

public class FactDecompData {
    public static Object[] decomp() {
        return $(
                $(17, "2^15 * 3^6 * 5^3 * 7^2 * 11 * 13 * 17"),
                $(5, "2^3 * 3 * 5"),
                $(22, "2^19 * 3^9 * 5^4 * 7^3 * 11^2 * 13 * 17 * 19"),
                $(14, "2^11 * 3^5 * 5^2 * 7^2 * 11 * 13"),
                $(25, "2^22 * 3^10 * 5^6 * 7^3 * 11^2 * 13 * 17 * 19 * 23")
        );
    }
}
