package kyu5;

import static junitparams.JUnitParamsRunner.$;

public class ToSmallestData {
    public static Object[] smallest() {
        return $(
                $(261235, new long[]{126235, 2, 0}),
                $(209917, new long[]{29917, 0, 1}),
                $(285365, new long[]{238565, 3, 1}),
                $(269045, new long[]{26945, 3, 0}),
                $(296837, new long[]{239687, 4, 1}),
                $(8020100889L, new long[]{201008889L, 0, 6}),

                $(8553787733764352L, new long[]{5537877337643528L, 1, 17}),
                $(272653229388649696L, new long[]{226532279388649696L, 1, 7}),
                $(118237984L, new long[]{112378984L, 2, 5})
        );
    }
}
