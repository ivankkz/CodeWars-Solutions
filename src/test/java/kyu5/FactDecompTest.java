package kyu5;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class FactDecompTest {

    @Test
    @Parameters(source = FactDecompData.class, method = "decomp")
    public void decomp(int num, String expected) {
        assertEquals(expected,FactDecomp.decomp(num));
    }
    @Test
    @Parameters(source = FactDecompData.class, method = "decomp")
    public void decomp2(int num, String expected) {
        assertEquals(expected,FactDecomp.decomp2(num));
    }
    @Test
    @Parameters(source = FactDecompData.class, method = "decomp")
    public void decomp3(int num, String expected) {
        assertEquals(expected,FactDecomp.decomp3(num));
    }
}
