package task1;

import java.util.concurrent.atomic.AtomicInteger;

class Counter extends Thread {
  private final AtomicInteger atomicInteger;

  public Counter(AtomicInteger atomicInteger) {
    this.atomicInteger = atomicInteger;
  }

  @Override
  public void run() {
    while (atomicInteger.get() < 20) {
      try {
        Thread.sleep(1000);
        if (atomicInteger.get() % 5 != 0) {
          System.out.println(atomicInteger.getAndIncrement());
        } else {
          atomicInteger.incrementAndGet();
        }
      } catch (InterruptedException e) {
        System.out.println("InterruptedException occurred in thread Counter");
        Thread.currentThread().interrupt();
      }
    }
  }
}