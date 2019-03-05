package benchmark;

import kyu5.FactDecom;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(value = 2)
@Warmup(iterations = 1)
@Measurement(iterations = 3)
public class BenchmarkTest {
    @State(Scope.Benchmark)
    public static class ExecutionPlan {
        @Param({"100", "1000", "10000","100000","1000000"})
        public static int num;
    }

    @Benchmark
    public void decomp(ExecutionPlan plan) {
        FactDecom.decomp(plan.num);
    }

    @Benchmark
    public void decomp2(ExecutionPlan plan) {
        FactDecom.decomp2(plan.num);
    }
}
