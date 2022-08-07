package general;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomics {

    public static void ints() {
        AtomicInteger x = new AtomicInteger();

        for(int i = 0; i < 10; i++) {
            x.incrementAndGet();
        }

        System.out.println(x);
    }

    public static void main(String[] args) {
        Atomics.ints();
    }
}
