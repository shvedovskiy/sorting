package main.bench;

import main.Helper;
import main.InsertionSort;
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
public class InsertionSortBench {

    private int[] arr;


    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        //arr = Helper.gen(10000);
        //arr = Helper.gen(50000);
        //arr = Helper.gen(100000);
        //arr = Helper.genIncreasing(10000);
        //arr = Helper.genIncreasing(50000);
        //arr = Helper.genIncreasing(100000);
        //arr = Helper.genDecreasing(10000);
        //arr = Helper.genDecreasing(50000);
        arr = Helper.genDecreasing(100000);
    }

    @Benchmark
    public void measureInsertionSort(Blackhole bh) {
        bh.consume(InsertionSort.insertionSort(arr));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(InsertionSortBench.class.getSimpleName())
                .warmupIterations(15)
                .measurementIterations(15)
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
