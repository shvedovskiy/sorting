package main.bench;

import main.Helper;
import main.MSDStrings;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class MSDStringsBench {
    private String[] arr;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        //arr = Helper.genStrings(10000, 200);
        //arr = Helper.genStrings(50000, 200);
        arr = Helper.genStrings(100000, 200);
        //arr = Helper.genMSDBest(10000, 200);
        //arr = Helper.genMSDBest(50000, 200);
        //arr = Helper.genMSDBest(100000, 200);
    }

    @Benchmark
    public void measureMSDStrings(Blackhole bh) {
        bh.consume(MSDStrings.msdSort(arr));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MSDStringsBench.class.getSimpleName())
                .warmupIterations(20)
                .measurementIterations(20)
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}



