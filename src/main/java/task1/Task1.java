package task1;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1 {

    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger();
        counter.set(1);

        Counter thread = new Counter(counter);
        thread.start();


        while (counter.get() < 20) {
            try {
                Thread.currentThread().join(5000);
                System.out.println("Passed 5 seconds");
            } catch (InterruptedException e) {
                System.err.println("Exception occurred in main thread");
                Thread.currentThread().interrupt();
            }
        }
    }
}