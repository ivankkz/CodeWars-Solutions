package kyu4;

import java.util.ArrayList;

//  Task description on https://www.codewars.com/kata/52b7ed099cdc285c300001cd
public final class ManagerOfInterval {
    public static int sumIntervals(int[][] intervals) {
        Interval[] res;
        int sum = 0;

        if (intervals == null)
            return -1;

        res = new Interval[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            res[i] = new Interval(intervals[i][0], intervals[i][1]);
        }

        res = Interval.mergeOverlappingIntervals(res);
        for (int i = 0; i < res.length; i++) {
            sum += Interval.lengthInterval(res[i]);
        }

        return sum;
    }
}

final class Interval {
    private int start; // including starting number [1, 5] = {1, 2, 3, 4}
    private int end;   // not including ending number

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static Interval[] mergeOverlappingIntervals(Interval[] arr) {
        boolean isUniqueInterval;
        int j;
        ArrayList<Interval> overlappingIntervals = new ArrayList<>();
        ArrayList<Interval> uniqueIntervals = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            isUniqueInterval = true;
            j = 0;

            while (j < uniqueIntervals.size()) {
                if (isIntervalsCrossing(uniqueIntervals.get(j), arr[i])) {
                    overlappingIntervals.add(uniqueIntervals.get(j));
                    uniqueIntervals.remove(j);
                    isUniqueInterval = false;
                } else
                    j++;
            }

            if (isUniqueInterval) {
                uniqueIntervals.add(arr[i]);
            } else {
                overlappingIntervals.add(arr[i]);
                uniqueIntervals.add(mergeIntervals(overlappingIntervals));
                overlappingIntervals.clear();
            }
        }

        return uniqueIntervals.stream().toArray(Interval[]::new);
    }

    public static int lengthInterval(Interval A) {
        return A.end - A.start;
    }

    private static boolean isIntervalsCrossing(Interval A, Interval B) {
        return (A.start <= B.end && B.start <= A.end);
    }

    private static Interval mergeIntervals(ArrayList<Interval> arr) {
        int min = arr.get(0).start;
        int max = arr.get(0).end;

        for (int i = 0; i < arr.size(); i++) {
            min = Math.min(min, arr.get(i).start);
            max = Math.max(max, arr.get(i).end);
        }

        return new Interval(min, max);
    }
}