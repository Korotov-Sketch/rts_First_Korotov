import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;


public class First {

    public static void main(String[] args) {
        long inputValue = 21659L;
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

        //StringBuilder key = new StringBuilder("Oleg");
        String key = "Oleg";
        long hash;
        long salt = 0;
        long start = System.currentTimeMillis();
        do {
            key = key+ salt;
            hash = (long) ((key.toString()).hashCode() % Math.pow(2, 64));
            salt++;
        } while (Math.abs(hash) >= inputValue);
        long finish = System.currentTimeMillis();
        long total = finish - start;
        System.out.println(total);
        System.out.println(salt);
        System.out.println(key);
    }
}