package main.bench;

import main.Helper;
import main.QuickSort;
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
public class QuickSortBench {
    private int[] arr;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        //arr = Helper.gen(10000);
        //arr = Helper.gen(50000);
        //arr = Helper.gen(100000);
        //arr = Helper.genIncreasing(10000);
        //arr = Helper.genIncreasing(50000);
        //arr = Helper.genIncreasing(100000);
        //arr = Helper.genAntiQuickSort(10000);
        //arr = Helper.genAntiQuickSort(50000);
        arr = Helper.genAntiQuickSort(100000);

    }

    @Benchmark
    public void measureQuickSort(Blackhole bh) {
        bh.consume(QuickSort.quickSort(arr));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(QuickSortBench.class.getSimpleName())
                .warmupIterations(10)
                .measurementIterations(10)
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}

