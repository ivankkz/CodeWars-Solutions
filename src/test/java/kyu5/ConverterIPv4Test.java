package kyu5;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class ConverterIPv4Test {

    @Test
    public void sampleTest() {
        assertEquals("128.114.17.104", ConverterIPv4.longToIP(2154959208L));
        assertEquals("0.0.0.0", ConverterIPv4.longToIP(0));
        assertEquals("128.32.10.1", ConverterIPv4.longToIP(2149583361L));
    }
}