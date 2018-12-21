package pro.puradawid.constructor;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

@Fork(10)
@Warmup(iterations = 20)
@Measurement(iterations = 50)
public class MyBenchmark {

    @State(Scope.Benchmark)
    public static class Dimension {
        public int w = 0;
        public int h = 0;
        public int d = 0;
    }

    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @Benchmark
    public double testPlainParametersMethod(Dimension d) {
        return new PlainParametersCuboid(d.w++, d.h++, d.d++, 0, 0, 0).volume();
    }

    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    @Benchmark
    public double testDataStructuredParametersMethod(Dimension d) {
        return new DataStructureParametersCuboid(
            new DataStructureParametersCuboid.Dimension(d.w++, d.h++, d.d++),
            new DataStructureParametersCuboid.Colour(0, 0, 0)).volume();
    }

}
