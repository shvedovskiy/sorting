package main.Laba_2.second.ch2.bench;

import main.Laba_2.second.ch2.Helper;
import main.Laba_2.second.ch2.InsertionSort;
import main.Laba_2.second.ch2.InsertionSortBinary;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class InsertionSortBench {

    private int[] arr;
    private int[][] data;
    int index;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        data = new int[10][100];
        for (int i = 0; i < 10; i++) {
            data[i] = Helper.gen(10000, 1000);
            //data[i] = Helper.gen(50000, 5000);
            //data[i] = Helper.gen(100000, 10000);


            //data[i] = Helper.genIncreasing(10000);
            //data[i] = Helper.genIncreasing(50000);
            //data[i] = Helper.genIncreasing(100000);


            //data[i] = Helper.genDecreasing(10000);
            //data[i] = Helper.genDecreasing(50000);
            //data[i] = Helper.genDecreasing(100000);
        }
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        arr = Arrays.copyOf(data[index], data[index].length);
        index = (index + 1) % 10;
    }

    @Benchmark
    public void measureInsertionSort(Blackhole bh) {
        bh.consume(InsertionSort.insertionSort(arr));
    }

    @Benchmark
    public void measureInsertionSortBinary(Blackhole bh) {
        bh.consume(InsertionSortBinary.insertionSort(arr));
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(InsertionSortBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
