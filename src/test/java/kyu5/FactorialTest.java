package kyu5;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void testZeros() throws Exception {
        assertThat(Factorial.zeros(0), is(0));
        assertThat(Factorial.zeros(6), is(1));
        assertThat(Factorial.zeros(14), is(2));
    }
}

