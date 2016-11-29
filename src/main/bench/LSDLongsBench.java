package main.bench;

import main.Helper;
import main.LSDLongs;
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
public class LSDLongsBench {
    private long[] arr;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        //arr = Helper.genLongs(10000);
        //arr = Helper.genLongs(50000);
        arr = Helper.genLongs(100000);
    }

    @Benchmark
    public void measureLSDLongs(Blackhole bh) {
        bh.consume(LSDLongs.lsdSort(arr));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(LSDLongsBench.class.getSimpleName())
                .warmupIterations(10)
                .measurementIterations(10)
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}


