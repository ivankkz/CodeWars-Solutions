package kyu4;

import java.util.ArrayList;
import java.util.LinkedList;

public final class ManagerOfInterval {
    public static int sumIntervals(int[][] intervals) {
        Interval[] res;

        if (intervals == null)
            return -1;

        res = new Interval[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            res[i] = new Interval(intervals[i][0], intervals[i][1]);
        }

        return Interval.lengthIntervals(res);
    }
}

final class Interval {
    private int start; // including starting number
    private int end;   // not including ending number

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static int lengthIntervals(Interval[] arr) {
        boolean isUniqueInterval;
        int sum = 0, j;
        ArrayList<Interval> overlappingIntervals = new ArrayList<>();
        LinkedList<Interval> uniqueIntervals = new LinkedList<>();

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

        for (Interval interval : uniqueIntervals) {
            sum += lengthInterval(interval);
        }

        return sum;
    }

    private static int lengthInterval(Interval A) {
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