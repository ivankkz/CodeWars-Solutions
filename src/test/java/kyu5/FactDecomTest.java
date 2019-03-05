package kyu5;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactDecomTest {

    @Test
    public void decomp() {
        assertEquals("2^15 * 3^6 * 5^3 * 7^2 * 11 * 13 * 17", FactDecom.decomp(17));
        assertEquals("2^3 * 3 * 5", FactDecom.decomp(5));
        assertEquals("2^19 * 3^9 * 5^4 * 7^3 * 11^2 * 13 * 17 * 19", FactDecom.decomp(22));
        assertEquals("2^11 * 3^5 * 5^2 * 7^2 * 11 * 13", FactDecom.decomp(14));
        assertEquals("2^22 * 3^10 * 5^6 * 7^3 * 11^2 * 13 * 17 * 19 * 23", FactDecom.decomp(25));
    }
}