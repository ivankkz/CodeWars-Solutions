package kyu6;

public class Phone {
    public static String createPhoneNumber(int[] numbers) {
        StringBuffer res = new StringBuffer("(");

        for (int i = 0; i < numbers.length; i++) {
            res.append(numbers[i]);
        }

        res.insert(7, "-");
        res.insert(4, ") ");

        return new String(res);
    }
}