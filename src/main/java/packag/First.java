package packag;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;


@State(Scope.Benchmark)
@Warmup(iterations = 1)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Measurement(iterations = 10, batchSize = 1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class First {

    //Процессор - Ryzen 5 3600
    //StringBuilder
    //83250 = 5562
    //83249 = 22747
    //Bench
    //83250 = 5960
    //83249 = 24469

    //String
    //21658 = 42953
    //21659 = 1915
    //bench
    //21658 = 46127
    //21659 = 2063

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    public static void process() {
        long inputValue = 83249L;

        // 10 замеров
            StringBuilder key = new StringBuilder("Oleg");
            //String key = "Oleg";
            long hash;
            long salt = 0;
            long start = System.currentTimeMillis();
            do {
                //key = key + salt; //string
                key.insert(0, salt); //stringbuilder
                hash = (long) ((key.toString()).hashCode() % Math.pow(2, 64));
                salt++;
            } while (Math.abs(hash) >= inputValue);
            long finish = System.currentTimeMillis();
            long total = finish - start;
            System.out.println(total);
            // System.out.println(salt);
            // System.out.println(key);
    }
}