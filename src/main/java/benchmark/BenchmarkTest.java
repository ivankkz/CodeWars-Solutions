package benchmark;

import kyu5.FactDecomp;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode({Mode.AverageTime})
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(value = 1)
@Warmup(iterations = 1)
@Measurement(iterations = 2)
public class BenchmarkTest {
    @State(Scope.Benchmark)
    public static class ExecutionPlan {
        @Param({"100000","1000000","10000000"})
        public static int num;
    }

    @Benchmark
    public void decomp(ExecutionPlan plan) {
        FactDecomp.decomp(plan.num);
    }

    @Benchmark
    public void decomp2(ExecutionPlan plan) {
        FactDecomp.decomp2(plan.num);
    }

    @Benchmark
    public void decomp3(ExecutionPlan plan) {
        FactDecomp.decomp3(plan.num);
    }
}
