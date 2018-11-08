package kyu5;

//  Task description on https://www.codewars.com/kata/int32-to-ipv4
public class ConverterIPv4 {
    public static String longToIP(long ip) {
        return (ip >> 24) + "." + (ip >> 16 & 0xFF) + "." + (ip >> 8 & 0xFF) + "." + (ip & 0xFF);
    }
}
