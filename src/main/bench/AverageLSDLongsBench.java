package main.bench;

import main.Helper;
import main.LSDLongs;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class AverageLSDLongsBench {
    long[][] data;
    long[] curr;
    int index;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        data = new long[10][100];
        for (int i = 0; i != 10; ++i) {
            //data[i] = Helper.genLongs(10000);
            //data[i] = Helper.genLongs(50000);
            data[i] = Helper.genLongs(100000);
        }
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        curr = Arrays.copyOf(data[index], data[index].length);
        index = (index + 1) % 10;
    }

    @Benchmark
    public void measureLSDLongs() {
        LSDLongs.lsdSort(curr);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(AverageLSDLongsBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}

