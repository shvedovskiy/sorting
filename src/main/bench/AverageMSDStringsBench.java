package main.bench;

import main.Helper;
import main.MSDStrings;
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
@Warmup(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 20, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
public class AverageMSDStringsBench {
    String[][] data;
    String[] curr;
    int index;

    @Setup(value = Level.Trial)
    public void setUpTrial() {
        data = new String[10][100];
        for (int i = 0; i != 10; ++i) {
            //data[i] = Helper.genStrings(10000, 200);
            //data[i] = Helper.genStrings(50000, 200);
            //data[i] = Helper.genStrings(100000, 200);

            //data[i] = Helper.genMSDBest(10000, 200);
            //data[i] = Helper.genMSDBest(50000, 200);
            data[i] = Helper.genMSDBest(100000, 200);

        }
    }

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        curr = Arrays.copyOf(data[index], data[index].length);
        index = (index + 1) % 10;
    }

    @Benchmark
    public void measureMSDStrings() {
        MSDStrings.msdSort(curr);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(AverageMSDStringsBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}

