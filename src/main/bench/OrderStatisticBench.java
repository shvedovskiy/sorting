package main.bench;

import main.Helper;
import main.OrderStatistic;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class OrderStatisticBench {
    private int[] arr;
    Random rand = ThreadLocalRandom.current();

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        //arr = Helper.gen(10000);
        //arr = Helper.gen(50000);
        //arr = Helper.gen(100000);
        //arr = Helper.genIncreasing(10000);
        //arr = Helper.genIncreasing(50000);
        //arr = Helper.genIncreasing(100000);
        arr = Helper.genDecreasing(10000);
    }

    @Benchmark
    public void measureOrderStatistic(Blackhole bh) {
        bh.consume(OrderStatistic.findOrderStatistic(arr, rand.nextInt(arr.length)));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(OrderStatisticBench.class.getSimpleName())
                .warmupIterations(10)
                .measurementIterations(10)
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}


